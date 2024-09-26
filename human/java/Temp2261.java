public class Temp2261 {
    static {
        System.loadLibrary("Temp2261"); // Load the native library containing the implementation of the native method
    }

    public native void loadResourcePdf(String fileName, VPdfViewer instance);

    public static void main(String[] args) {
        Temp2261 temp = new Temp2261();
        VPdfViewer viewer = new VPdfViewer();
        temp.loadResourcePdf("example.pdf", viewer);
    }
}

class VPdfViewer {
    public JSObject jsObject;

    public VPdfViewer() {
        // Initialize the jsObject or perform other necessary setup
    }

    // Add methods and fields as needed
}

class JSObject {
    public boolean work;
    public String fileName;
    public Object pdfFile;
    public int pageCount;
    public int pageNumber;

    public void showPdfPage(int pageNumber) {
        // Implement the logic to show the PDF page
    }
}