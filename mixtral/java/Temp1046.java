public class Temp1046 {
    public static void main(String[] args) {
        Temp1046 temp = new Temp1046();
        temp.logoDropzoneConfig();
    }

    public void logoDropzoneConfig() {
        DropzoneConfig config = new DropzoneConfig();
        config.setParallelUploads(1);
        config.setMaxFileSize(30);

        config.setAddedFileCallback(file -> {
            sendFile(file);
            config.removeFile(file);
        });
    }

    public void sendFile(File file) {
        // Implementation for sending the file
        System.out.println("Sending file: " + file.getName());
    }

    class DropzoneConfig {
        private int parallelUploads;
        private int maxFileSize;
        private AddedFileCallback addedFileCallback;

        public void setParallelUploads(int parallelUploads) {
            this.parallelUploads = parallelUploads;
        }

        public void setMaxFileSize(int maxFileSize) {
            this.maxFileSize = maxFileSize;
        }

        public void setAddedFileCallback(AddedFileCallback callback) {
            this.addedFileCallback = callback;
        }

        public void removeFile(File file) {
            // Implementation for removing the file
            System.out.println("Removing file: " + file.getName());
        }

        interface AddedFileCallback {
            void addedfile(File file);
        }
    }

    class File {
        private String name;

        public File(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}