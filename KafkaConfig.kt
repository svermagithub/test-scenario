import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.config.SslConfigs
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import java.io.File
import java.util.Properties

@Configuration
class KafkaConfig {

    // Replace these with your Kafka broker properties
    private val kafkaBrokers = "kafka-broker1:9093,kafka-broker2:9093"

    @Bean
    fun producerFactory(): ProducerFactory<String, Any> {
        val configProps = Properties()
        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaBrokers
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = "org.apache.kafka.common.serialization.StringSerializer"
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        configProps[ProducerConfig.ACKS_CONFIG] = "all"
        configProps[ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION] = "1"
        configProps[ProducerConfig.RETRIES_CONFIG] = "3"

        // SSL Configuration
        configProps[CommonClientConfigs.SECURITY_PROTOCOL_CONFIG] = "SSL"
        configProps[SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG] = "/path/to/truststore.jks"
        configProps[SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG] = "truststore-password"
        configProps[SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG] = "/path/to/keystore.jks"
        configProps[SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG] = "keystore-password"

        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Any> {
        return KafkaTemplate(producerFactory())
    }

    @Bean
    fun consumerFactory(): ConsumerFactory<String, Any> {
        val configProps = Properties()
        configProps[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaBrokers
        configProps[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = "org.apache.kafka.common.serialization.StringDeserializer"
        configProps[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = "org.springframework.kafka.support.serializer.JsonDeserializer"
        configProps[ConsumerConfig.GROUP_ID_CONFIG] = "kafka-consumer-group"

        // SSL Configuration
        configProps[CommonClientConfigs.SECURITY_PROTOCOL_CONFIG] = "SSL"
        configProps[SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG] = "/path/to/truststore.jks"
        configProps[SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG] = "truststore-password"
        configProps[SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG] = "/path/to/keystore.jks"
        configProps[SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG] = "keystore-password"

        return DefaultKafkaConsumerFactory(configProps)
    }
}
