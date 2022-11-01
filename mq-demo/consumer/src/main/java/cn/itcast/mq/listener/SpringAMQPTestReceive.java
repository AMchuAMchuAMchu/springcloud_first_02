package cn.itcast.mq.listener;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Description ==> TODO
 * BelongsProject ==> springcloud_first_02
 * BelongsPackage ==> cn.itcast.mq.listener
 * Version ==> 1.0
 * CreateTime ==> 2022-11-01 17:08:39
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@Component
public class SpringAMQPTestReceive {
//
//    @RabbitListener(queues = "simple.queue")
//    public void getSQ1(String msg1) throws InterruptedException {
//
//        System.out.println("消费者一接收到的消息 >> "+msg1);
//        TimeUnit.MILLISECONDS.sleep(20);
//
//    }
//
//    @RabbitListener(queues = "simple.queue")
//    public void getSQ2(String msg2) throws InterruptedException {
//
//        System.out.println("消费者二接收到的消息 >> "+msg2);
//        TimeUnit.MILLISECONDS.sleep(200);
//
//    }

//
//    @RabbitListener(queues = "queue01")
//    public void getQ01(String msg01){
//        System.out.println("queue01 >> "+msg01);
//    }
//
//    @RabbitListener(queues = "queue02")
//    public void getQ02(String msg02){
//        System.out.println("queue02 >> "+msg02);
//    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "queue01"),
            exchange = @Exchange(name = "directExchange",type = ExchangeTypes.DIRECT),key = {"red","blue"}))
    public void queue01(String msg01){
        System.out.println("RB queue01 >> "+msg01);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("queue02"),
    exchange = @Exchange(name = "directExchange",type = ExchangeTypes.DIRECT),key = {"red","yellow"}))
    public void queue02(String msg02){
        System.out.println("RY queue02 >> "+msg02);
    }

}
