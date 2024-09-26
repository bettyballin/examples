public class Temp2353 {

    // Mocked ApplicationSettings class
    static class ApplicationSettings {
        private String value;

        public ApplicationSettings(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    // Mocked ApplicationSettingsDao class
    static class ApplicationSettingsDao {
        public ApplicationSettings getSettingsByKey(String key) {
            return new ApplicationSettings("true"); // Mocked to return "true" for simplicity
        }
    }

    // Mocked Constants class
    static class Constants {
        public static final String CONFIG_VALUE = "config_value";
    }

    private ApplicationSettingsDao applicationSettingsDao = new ApplicationSettingsDao();

    public static void main(String[] args) {
        Temp2353 temp = new Temp2353();
        System.out.println(temp.isConfigValue());
    }

    public boolean isConfigValue() {
        ApplicationSettings settings = applicationSettingsDao.getSettingsByKey(Constants.CONFIG_VALUE);

        // Handle null checks
        return (settings != null && "true".equalsIgnoreCase(settings.getValue()));
    }
}