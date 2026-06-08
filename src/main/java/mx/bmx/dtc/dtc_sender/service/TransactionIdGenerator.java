package mx.bmx.dtc.dtc_sender.service;

import java.time.Clock;

public interface TransactionIdGenerator {
    String generate(String stream, String blueGreen, String domainPrefix, Clock clock, Long timestamp);
}
