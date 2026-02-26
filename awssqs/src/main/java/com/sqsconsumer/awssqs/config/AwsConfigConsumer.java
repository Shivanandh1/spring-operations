package com.sqsconsumer.awssqs.config;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import io.awspring.cloud.sqs.config.SqsMessageListenerContainerFactory;
import io.awspring.cloud.sqs.listener.acknowledgement.AcknowledgementResultCallback;
import io.awspring.cloud.sqs.listener.acknowledgement.handler.AcknowledgementMode;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class AwsConfigConsumer {

//private static final Logger logger= (Logger) LoggerFactory.getLogger(AwsConfigConsumer.class);

    @Bean("defaultSqsListenerContainerFactory")
    public SqsMessageListenerContainerFactory<Object> defaultSqsMessageListenerContainerFactory(SqsAsyncClient sqsAsyncClient){

            return SqsMessageListenerContainerFactory.builder().configure(options-> options.acknowledgementMode(AcknowledgementMode.MANUAL)
                            .acknowledgementInterval(Duration.ofSeconds(3)).acknowledgementThreshold(0)
                            ).acknowledgementResultCallback(new AckResultCallBack() ).sqsAsyncClient(sqsAsyncClient).build();
    }


  static class AckResultCallBack implements AcknowledgementResultCallback<Object>{

      @Override
      public void onSuccess(Collection<Message<Object>> messages){
          System.out.println("ack with success at {}"+ OffsetDateTime.now());
      }
      @Override
      public void onFailure(Collection<Message<Object>>messages,Throwable t){
          System.out.println("ack with fail"+t);

      }
  }
}
