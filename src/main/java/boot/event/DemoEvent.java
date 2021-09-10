package boot.event;

import boot.common.Result;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    public String msg;
    private OnFinishedListener onFinishedListener;


    public DemoEvent(Object source, String msg, OnFinishedListener onFinishedListener) {
        super(source);
        this.msg = msg;
        this.onFinishedListener = onFinishedListener;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public OnFinishedListener getOnFinishedListener() {
        return this.onFinishedListener;
    }

    public void setOnFinishedListener(OnFinishedListener onFinishedListener) {
        this.onFinishedListener = onFinishedListener;
    }


    public interface OnFinishedListener {
        void onFinished(Result result);
    }

}