public class Temp1877 {
    public static void main(String[] args) {
        LogoDropzoneConfig logoDropzoneConfig = new LogoDropzoneConfig();
        logoDropzoneConfig.setParallelUploads(1);
        logoDropzoneConfig.setMaxFileSize(30);
        logoDropzoneConfig.setUrl("/api/companies/upload/logo");
        logoDropzoneConfig.setHeaders(new Headers("Authorization", AuthServerProvider.getToken()));
        
        // You can add code here to use the logoDropzoneConfig object as needed
    }
}

class LogoDropzoneConfig {
    private int parallelUploads;
    private int maxFileSize;
    private String url;
    private Headers headers;

    public void setParallelUploads(int parallelUploads) {
        this.parallelUploads = parallelUploads;
    }

    public void setMaxFileSize(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }
}

class Headers {
    private String key;
    private String value;

    public Headers(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

class AuthServerProvider {
    public static String getToken() {
        // Mock implementation, replace with actual token retrieval logic
        return "mock-token";
    }
}