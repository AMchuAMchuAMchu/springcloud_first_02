package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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
    public void getSQ(String msg){

        System.out.println("接收到的消息 >> "+msg);

    }


}
