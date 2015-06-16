package Model;

public interface RequestEvent {
    
    void onSuccess(Object response);
    void onFailed();
    void onRunning();
    
}
