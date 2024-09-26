import org.springframework.stereotype.Component;
import org.springframework.context.SmartLifecycle;

@Component
public class MyLifecycleBean implements SmartLifecycle {
    private boolean isRunning = false;

    @Override
    public void start() {
        // Start the component.
        isRunning = true;
    }

    @Override
    public void stop() {
        // Stop the component.
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        // Check if component is currently running.
        return isRunning;
    }

    @Override
    public int getPhase() {
        // Return the phase value of this component.
        return 0;
    }

    @Override
    public boolean isAutoStartup() {
        // Should this component start automatically.
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        // Stop the component with a callback.
        stop();
        callback.run();
    }
}