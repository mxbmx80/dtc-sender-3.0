package mx.bmx.dtc.dtc_sender.service.impl;

import mx.bmx.dtc.dtc_sender.service.TransactionIdGenerator;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.time.Clock;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Component
class TransactionIdGeneratorImpl implements TransactionIdGenerator {
    private static final int MAX_STREAM_LENGTH = 3;
    private static final int MAX_DOMAIN_PREFIX_LENGTH = 4;
    private static final int POD_ID_LENGTH = 4;
    private static final int BLUE_GREEN_LENGTH = 1;
    private static final String PREFIX = "TS.";
    private static final int MAX_ID_LENGTH = 26;

    private final String podId;

    private final AtomicReference<GenState> state = new AtomicReference<>(new GenState(0L, new AtomicInteger(0)));

    private static class GenState {
        final long timestamp;
        final AtomicInteger counter;

        GenState(long timestamp, AtomicInteger counter) {
            this.timestamp = timestamp;
            this.counter = counter;
        }
    }

    public TransactionIdGeneratorImpl() {
        String hostName;
        try {
            hostName = InetAddress.getLocalHost().getHostName().toUpperCase();
        } catch (Exception e) {
            hostName = "UNKNOWN";
        }
        if (hostName.length() <= POD_ID_LENGTH) {
            this.podId = String.format("%" + POD_ID_LENGTH + "s", hostName).replace(' ', '0');
        } else {
            this.podId = hostName.substring(hostName.length() - POD_ID_LENGTH);
        }
    }

    @Override
    public String generate(
            String stream,
            String blueGreen,
            String domainPrefix,
            Clock clock,
            Long timestamp
    ) {
        validate(stream, blueGreen, domainPrefix);

        long currentTimestamp = timestamp != null ? timestamp : Instant.now(clock).toEpochMilli();
        int index = getNextIndex(currentTimestamp);

        String body;
        if (!domainPrefix.isEmpty()) {
            body = domainPrefix + currentTimestamp + index + podId;
        } else {
            String streamCode = padStart(stream.toUpperCase(), MAX_STREAM_LENGTH, '0');
            String bgCode = blueGreen.toUpperCase();
            body = streamCode + bgCode + currentTimestamp + index + podId;
        }

        String result = PREFIX + body;
        if (result.length() > MAX_ID_LENGTH) {
            throw new IllegalStateException(
                    "Сгенерированный ID получился больше допустимой длины " + result.length() + ", максимум: " + MAX_ID_LENGTH + ". " +
                            "Такое возможно если в 1 мс пришел запрос на генерацию больше 99 ID одновременно."
            );
        }
        return result;
    }

    private int getNextIndex(long ts) {
        while (true) {
            GenState current = state.get();
            if (current.timestamp == ts) {
                return current.counter.incrementAndGet();
            }
            GenState newState = new GenState(ts, new AtomicInteger(1));
            if (state.compareAndSet(current, newState)) {
                return 1;
            }
        }
    }

    private void validate(String stream, String blueGreen, String domainPrefix) {
        if (stream.length() > MAX_STREAM_LENGTH) throw new IllegalArgumentException("Stream too long");
        if (blueGreen.length() > BLUE_GREEN_LENGTH) throw new IllegalArgumentException("Blue/Green too long");
        if (!domainPrefix.isEmpty() && domainPrefix.length() != MAX_DOMAIN_PREFIX_LENGTH) {
            throw new IllegalArgumentException("Domain prefix length must be " + MAX_DOMAIN_PREFIX_LENGTH);
        }
    }

    private static String padStart(String str, int length, char padChar) {
        if (str.length() >= length) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = str.length(); i < length; i++) {
            sb.append(padChar);
        }
        sb.append(str);
        return sb.toString();
    }
}
