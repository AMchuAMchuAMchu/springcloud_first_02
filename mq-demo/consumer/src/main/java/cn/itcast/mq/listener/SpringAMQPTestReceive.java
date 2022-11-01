package cn.itcast.mq.listener;

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

    @RabbitListener(queues = "simple.queue")
    public void getSQ1(String msg1) throws InterruptedException {

        System.out.println("消费者一接收到的消息 >> "+msg1);
        TimeUnit.MILLISECONDS.sleep(20);

    }

    @RabbitListener(queues = "simple.queue")
    public void getSQ2(String msg2) throws InterruptedException {

        System.out.println("消费者二接收到的消息 >> "+msg2);
        TimeUnit.MILLISECONDS.sleep(200);

    }


}
