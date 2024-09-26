import java.io.*;

public class Temp250 {
    public static void main(String[] args) {
        try {
            // Create an example input stream for demonstration
            String exampleData = "Header1: value1\nHeader2: value2\n\nBody content here";
            InputStream inputStream = new ByteArrayInputStream(exampleData.getBytes());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Mark the current position in the stream
            inputStream.mark(Integer.MAX_VALUE);

            // Read the request header line by line
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                // Process the header line
                System.out.println("Header: " + line);
            }

            // Reset the position to the marked point
            inputStream.reset();

            // Read the body data if any
            int contentLength = exampleData.length();
            if (contentLength > 0) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                String body = new String(outputStream.toByteArray(), "UTF-8");
                System.out.println("Body: " + body);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}