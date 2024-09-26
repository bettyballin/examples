import javax.persistence.Column;
import javax.persistence.Transient;

public class Temp1814 {
    @Column(name = "image_file")
    private byte[] imageFile;

    @Transient
    private MultipartFile multiPartFile;

    public void setMultiPartFile(MultipartFile multiPartFile) {
        this.multiPartFile = multiPartFile;
        if (multiPartFile != null) {
            try {
                this.setImageFile(multiPartFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setImageFile(byte[] imageFile) {
        this.imageFile = imageFile;
    }

    public static void main(String[] args) {
        // Example usage
        Temp1814 temp = new Temp1814();
        // Assuming multipartFile is an instance of MultipartFile with valid data
        // temp.setMultiPartFile(multipartFile);
    }
}

interface MultipartFile {
    byte[] getBytes() throws IOException;
}