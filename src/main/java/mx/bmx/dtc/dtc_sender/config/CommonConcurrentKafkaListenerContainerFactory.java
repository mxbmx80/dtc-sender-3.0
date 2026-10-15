package mx.bmx.dtc.dtc_sender.config;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

public class CommonConcurrentKafkaListenerContainerFactory<K, V> extends ConcurrentKafkaListenerContainerFactory<K, V> {

    public CommonConcurrentKafkaListenerContainerFactory() {
        setCommonErrorHandler(new SkipRecordDeserializationErrorHandler());
    }
}
