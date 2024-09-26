import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Temp3532 {
    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet 1");
        
        System.out.println("Workbook and sheet created successfully.");
        
        // Clean up resources
        try {
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


xml
<!-- Add this to your pom.xml to include the Apache POI dependency -->
<dependencies>
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>4.1.2</version>
    </dependency>
</dependencies>