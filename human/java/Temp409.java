public class Temp409 {
    public static void main(String[] args) {
        // Example usage of the sanitizeScript method
        Temp409 temp = new Temp409();
        String script = "var a = 1 + 1";
        try {
            String sanitizedScript = temp.sanitizeScript(script);
            System.out.println(sanitizedScript);
        } catch (ScriptedPermissionsException e) {
            System.out.println(e.getMessage());
        }
    }

    private String sanitizeScript(String script) {
        if (containsMoreThanOneStatement(script)) {
            throw new ScriptedPermissionsException("Scripts may only contain one statement!!");
        }
        return new StringBuilder()
                .append("function importPackage(a){ throw 'Cannot import!'};").append('\n')
                .append("function importClass(a){ throw 'Cannot import!'};").append('\n')
                .append("function JavaImporter(a){ throw 'I said, no importing!!'};").append('\n')
                .append(script).append(';')
                .toString();
    }

    private boolean containsMoreThanOneStatement(String script) {
        // Dummy implementation for demonstration
        // In a real scenario, you would need to parse the script properly
        return script.contains(";");
    }

    static class ScriptedPermissionsException extends RuntimeException {
        public ScriptedPermissionsException(String message) {
            super(message);
        }
    }
}