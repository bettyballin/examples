import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Example usage
        LibraryError libError = new LibraryError("Some error message");
        Reason reason = new Reason(libError);
        CompanyError companyError = new CompanyError("ID123", "Company error message");
    }

    public static class CompanyError {
        private String identifier;
        private String message;
        private List<Reason> reasons;

        public CompanyError(String identifier, String message) {
            this.identifier = identifier;
            this.message = message;
            this.reasons = new ArrayList<>();
        }

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<Reason> getReasons() {
            return reasons;
        }

        public void setReasons(List<Reason> reasons) {
            this.reasons = reasons;
        }
    }

    public static class Reason {
        private LibraryError libraryError;

        public Reason(LibraryError error) {
            this.libraryError = error;
        }

        public LibraryError getLibraryError() {
            return libraryError;
        }

        public void setLibraryError(LibraryError libraryError) {
            this.libraryError = libraryError;
        }
    }

    public static class LibraryError {
        private String errorMessage;

        public LibraryError(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}