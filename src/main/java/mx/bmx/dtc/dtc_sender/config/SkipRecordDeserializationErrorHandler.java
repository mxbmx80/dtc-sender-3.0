package mx.bmx.dtc.dtc_sender.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.errors.RecordDeserializationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.listener.BackOffHandler;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.util.backoff.BackOff;

@Slf4j
@SuppressWarnings("unused")
public class SkipRecordDeserializationErrorHandler extends DefaultErrorHandler {

    public SkipRecordDeserializationErrorHandler() {
        super();
    }

    public SkipRecordDeserializationErrorHandler(final BackOff backOff) {
        super(backOff);
    }

    public SkipRecordDeserializationErrorHandler(final ConsumerRecordRecoverer recoverer) {
        super(recoverer);
    }

    public SkipRecordDeserializationErrorHandler(final ConsumerRecordRecoverer recoverer, final BackOff backOff) {
        super(recoverer, backOff);
    }

    public SkipRecordDeserializationErrorHandler(
            final ConsumerRecordRecoverer recoverer, final BackOff backOff, final BackOffHandler backOffHandler
    ) {
        super(recoverer, backOff, backOffHandler);
    }

    @Override
    public void handleOtherException(
            final @NotNull Exception thrownException, final @NotNull Consumer<?, ?> consumer,
            final @NotNull MessageListenerContainer container, final boolean batchListener
    ) {
        if (thrownException instanceof RecordDeserializationException exception) {
            log.error("Error while deserialization Kafka event", exception);
            consumer.seek(exception.topicPartition(), exception.offset() + 1L);
            consumer.commitSync();
            return;
        }
        super.handleOtherException(thrownException, consumer, container, batchListener);
    }
}

