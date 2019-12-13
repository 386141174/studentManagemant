package com.inventec.studentManagement.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* 类说明
* @author  Criss.liu
* @version V1.0  创建时间：2019年12月10日 上午11:00:39
*/

@Configuration
public class RabbitConfig {
	 //创建两个队列
    @Bean(name = "queuemessage")
    public  Queue queuemessage(){
        return new Queue("student.info");
        
    }

    
    @Bean(name = "queuemessages")
    public Queue queuemessages(){
        return new Queue("student.score");
    }
    
    //创建交换机
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("studentManagement");
    }
    
    
//    //绑定队列
    @Bean
    Binding binding1(@Qualifier("queuemessages")Queue queuemessage,TopicExchange exchange){
        return BindingBuilder.bind(queuemessage).to(exchange).with("*.score");
    }
    
    //绑定队列
        @Bean
        Binding binding2(@Qualifier("queuemessage")Queue queuemessages,TopicExchange exchange){
            return BindingBuilder.bind(queuemessages).to(exchange).with("*.info");
        }
	
	
}
