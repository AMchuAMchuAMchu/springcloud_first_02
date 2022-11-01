package cn.itcast.mq.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description ==> TODO
 * BelongsProject ==> springcloud_first_02
 * BelongsPackage ==> cn.itcast.mq.config
 * Version ==> 1.0
 * CreateTime ==> 2022-11-01 17:56:06
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@Configuration
public class CFFanoutConfig {

    @Bean
    public Queue queue01() {
        return new Queue("fanout.queue01");
    }

    @Bean
    public Queue queue02() {
        return new Queue("fanout.queue02");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("itcast.fanout");
    }

    @Bean
    public Binding binding01(Queue queue01, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue01).to(fanoutExchange);
    }

    @Bean
    public Binding binding02(Queue queue02, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue02).to(fanoutExchange);
    }


}
