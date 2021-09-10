package boot.publisher;


import boot.common.Result;
import boot.event.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DemoPublisher {

    @Autowired
    //注入ApplicationContext用来发布事件
    ApplicationContext applicationContext;

    //使用ApplicationContext的publishEvent方法来发布
    public List<Result> publish(String msgs) {
        List<String> list = Arrays.asList(msgs.split(","));
        List<Result> results = new ArrayList<>();
        list.forEach(msg -> {
            applicationContext.publishEvent(new DemoEvent(this, msg, results::add));
        });
        return results;
    }
}