package com.example.springbootmp.kafka;

import com.google.common.collect.Lists;
import org.apache.kafka.clients.KafkaClient;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DeleteConsumerGroupsResult;
import org.apache.kafka.common.KafkaFuture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author BCY
 */
@SpringBootTest
public class KafkaAdminTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        Properties prop = new Properties();
        prop.put("bootstrap.servers","192.168.1.85:9092");
        AdminClient client = AdminClient.create(prop);

        DeleteConsumerGroupsResult result = client.deleteConsumerGroups(Lists.newArrayList("mp1"));
    }
}
