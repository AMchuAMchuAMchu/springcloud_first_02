package cn.itcast.mq.helloworld;

import cn.itcast.mq.pojo.AnimeInfo;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherTest {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testObjectTransfer(){

        String fanoutExchange = "topicExchange";

        String message = "hello,china.news";
        AnimeInfo animeInfo = new AnimeInfo();
        animeInfo.setName("刀剑神域");
        animeInfo.setTime(20221106);
        rabbitTemplate.convertAndSend(fanoutExchange,"china.news",animeInfo);


    }

    @Test
    public void testPublishSubscribeTopic(){

        String fanoutExchange = "topicExchange";

        String message = "hello,Japan.news";
        rabbitTemplate.convertAndSend(fanoutExchange,"Japan.news",message);


    }
    @Test
    public void testPublishSubscribeDirect(){

        String fanoutExchange = "directExchange";

        String message = "hello,directExchange... red!red!!blue!!!";
        rabbitTemplate.convertAndSend(fanoutExchange,"red",message);


    }

    @Test
    public void testPublishSubscribe(){

        String fanoutExchange = "fanoutExchange";

        String message = "hello,fanoutExchange...";
        rabbitTemplate.convertAndSend(fanoutExchange,"",message);


    }

    @Test
    public void testSpringAMQPSend() throws InterruptedException {

        String queueName = "simple.queue";

        String message = "hello,springamqp!!!";

        for (int i = 1; i <= 50; i++) {

            rabbitTemplate.convertAndSend(queueName, message+i);
            TimeUnit.MILLISECONDS.sleep(20);

        }


    }

    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        // 1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        // 1.1.设置连接参数，分别是：主机名、端口号、vhost、用户名、密码
        factory.setHost("192.168.200.130");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("itcast");
        factory.setPassword("123321");
        // 1.2.建立连接
        Connection connection = factory.newConnection();

        // 2.创建通道Channel
        Channel channel = connection.createChannel();

        // 3.创建队列
        String queueName = "simple.queue";
        channel.queueDeclare(queueName, false, false, false, null);

        // 4.发送消息
        String message = "hello, rabbitmq!";
        channel.basicPublish("", queueName, null, message.getBytes());
        System.out.println("发送消息成功：【" + message + "】");

        // 5.关闭通道和连接
        channel.close();
        connection.close();

    }
}
