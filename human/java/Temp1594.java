public class Temp1594 {

    public static void main(String[] args) {
        Temp1594 temp = new Temp1594();
        try {
            String result = temp.getValid("context", "input");
            System.out.println("Validation result: " + result);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public String getValid(String context, String input) throws ValidationException {
        String data = null;

        // checks on input itself

        // check for empty/null
        if (checkEmpty(context, input) == null)
            return null;

        boolean validateInputAndCanonical = true; // Assuming this is defined somewhere

        if (validateInputAndCanonical) {
            // first validate pre-canonicalized data

            // check length
            checkLength(context, input);

            // check whitelist patterns
            checkWhitelist(context, input);

            // check blacklist patterns
            checkBlacklist(context, input);

            // canonicalize
            data = encoder.canonicalize(input); // Assuming encoder is defined somewhere

        } else {

            // skip canonicalization
            data = input;
        }

        // check for empty/null
        if (checkEmpty(context, data) == null)
            return null;

        // check length
        checkLength(context, data);

        // check whitelist patterns
        checkWhitelist(context, data);

        // check blacklist patterns
        checkBlacklist(context, data);

        // validation passed
        return data;
    }

    private String checkEmpty(String context, String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        return input;
    }

    private void checkLength(String context, String input) throws ValidationException {
        if (input.length() > 255) {
            throw new ValidationException("Input length is too long");
        }
    }

    private void checkWhitelist(String context, String input) throws ValidationException {
        if (!input.matches("[a-zA-Z0-9]*")) {
            throw new ValidationException("Input contains invalid characters");
        }
    }

    private void checkBlacklist(String context, String input) throws ValidationException {
        if (input.contains("badword")) {
            throw new ValidationException("Input contains blacklisted words");
        }
    }

    // Assuming ValidationException is defined somewhere
    public class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }

    // Assuming Encoder is defined somewhere
    private Encoder encoder = new Encoder();

    private class Encoder {
        public String canonicalize(String input) {
            // Dummy implementation for canonicalization
            return input.replaceAll("[<>]", "");
        }
    }
}