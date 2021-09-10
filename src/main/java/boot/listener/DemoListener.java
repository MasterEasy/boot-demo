package boot.listener;

import boot.common.Result;
import boot.event.DemoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//实现ApplicationListener接口，并指定监听的事件类型
@Component
@Slf4j
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    //使用onApplicationEvent方法对消息进行接收处理
    public void onApplicationEvent(DemoEvent demoEvent) {
        Integer msg = Integer.parseInt(demoEvent.getMsg());


        if (msg % 2 == 0) {
            log.info("正确的信息为偶数：{}", msg);
            demoEvent.getOnFinishedListener().onFinished(Result.OK(msg));
        } else {
            log.error("错误的信息为奇数：{}", msg);
            demoEvent.getOnFinishedListener().onFinished(Result.error(500,demoEvent.getMsg()));
        }

        //System.out.println("(bean-demoListener)接收到了bean-demoPublisher发布的消息:"+result.getResult());
        //demoEvent.getOnFinishedListener().onFinished(msg);
    }
}