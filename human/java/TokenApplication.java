import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class TokenApplication {
    static ObjectMapper objectMapper = new ObjectMapper()
            .configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

    public static void main(String[] args) {
        ProjectConfig projectConfig = loadConfiguration("application-stg.properties");

        if (args.length > 0 && args[0].equals("PROD")) {
            projectConfig = loadConfiguration("application-prod.properties");
        }
        try {
            JWTTokenService jwtTokenService = new JWTTokenService();
            System.out.println(jwtTokenService.getJwtToken(projectConfig).getAccessToken());
            System.exit(JobStatus.SUCCESS.getCode());
        } catch (Exception ex) {
            System.exit(JobStatus.PROCESS_FAILED.getCode());
        }

    }

    private static ProjectConfig loadConfiguration(String filePath) {
        try (InputStream input = TokenApplication.class.getClassLoader().getResourceAsStream(filePath)) {
            Properties props = new Properties();
            props.load(input);
            return objectMapper.convertValue(new HashMap(props), ProjectConfig.class);
        } catch (Exception ex) {
            throw new RuntimeException("Not able to load configuration" + ex.getMessage());
        }
    }
}

class ProjectConfig {
    // Define fields and methods for ProjectConfig
}

class JWTTokenService {
    public JwtToken getJwtToken(ProjectConfig projectConfig) {
        // Implement the method to return a JwtToken
        return new JwtToken("sampleAccessToken");
    }
}

class JwtToken {
    private String accessToken;

    public JwtToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}

enum JobStatus {
    SUCCESS(0),
    PROCESS_FAILED(1);

    private final int code;

    JobStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}