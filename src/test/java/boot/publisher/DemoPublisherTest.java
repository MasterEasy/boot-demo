package boot.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoPublisherTest {

    @Autowired
    DemoPublisher demoPublisher;

    @Test
    public void test() {
        demoPublisher.publish("1,2,3,4,5,6");
    }

    @Test
    public void test2() {

    }

}