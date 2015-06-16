package Controller;

import Model.RequestEvent;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;

public class Requester {
    
    private Object request;
    private Object data;
    private final Task<Object> task;
    private RequestEvent event;
    
    private Thread thread;

    public Requester() {
        this.event = null;
        this.request = "";
        this.data = "";
        task = new Task<Object>() {

            @Override
            protected Object call() throws Exception {
                return process();
            }
        };
        this.thread = new Thread(task);
    }

    public Requester(RequestEvent event) {
        this.event = event;
        this.request = "";
        this.data = "";
        task = new Task<Object>() {

            @Override
            protected Object call() throws Exception {
                return process();
            }
        };
        this.thread = new Thread(task);
    }

    public Requester(Object request, Object data, RequestEvent event) {
        this.request = request;
        this.data = data;
        this.event = event;
        task = new Task<Object>() {

            @Override
            protected Object call() throws Exception {
                return process();
            }
        };
        this.task.setOnFailed(e -> {
            event.onFailed();
        });
        this.task.setOnSucceeded(e -> {
            try {
                event.onSuccess(this.task.get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Requester.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.task.setOnRunning(e -> {
            event.onRunning();
        });
        this.thread = new Thread(task);
    }
    
    private Object process() {
        return ClientTest.RequestAjluulah(this.request, this.data);
    }

    public void setRequest(Object request, Object data) {
        this.request = request;
        this.data = data;
    }

    public void setEvent(RequestEvent event) {
        this.event = event;
    }
    
    public void start() {
        this.thread.start();
    }
    
    public Object getResponse() {
        try {
            return this.task.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Requester.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
