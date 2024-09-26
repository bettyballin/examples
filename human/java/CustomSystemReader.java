import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.storage.file.FileBasedConfig;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.SystemReader;

public class CustomSystemReader extends SystemReader {
    private final SystemReader systemReader;

    public CustomSystemReader(SystemReader systemReader) {
        this.systemReader = systemReader;
    }

    @Override
    public String getHostname() {
        return systemReader.getHostname();
    }

    @Override
    public String getenv(String variable) {
        if ("GIT_SSH".equals(variable))
            return "/usr/bin/ssh";
        return systemReader.getenv(variable);
    }

    @Override
    public String getProperty(String key) {
        return systemReader.getProperty(key);
    }

    @Override
    public FileBasedConfig openUserConfig(Config parent, FS fs) {
        return systemReader.openUserConfig(parent, fs);
    }

    @Override
    public FileBasedConfig openSystemConfig(Config parent, FS fs) {
        return systemReader.openSystemConfig(parent, fs);
    }

    @Override
    public long getCurrentTime() {
        return systemReader.getCurrentTime();
    }

    @Override
    public int getTimezone(long when) {
        return systemReader.getTimezone(when);
    }

    public static void main(String[] args) {
        SystemReader originalReader = SystemReader.getInstance();
        CustomSystemReader customReader = new CustomSystemReader(originalReader);
        SystemReader.setInstance(customReader);

        // Test the custom environment variable override
        System.out.println("GIT_SSH: " + SystemReader.getInstance().getenv("GIT_SSH"));
    }
}