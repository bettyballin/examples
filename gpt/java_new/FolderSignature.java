import java.io.*;
import java.util.zip.*;

public class FolderSignature {

    // Method to create a ZIP file from a folder
    public static void zipFolder(String sourceFolder, String outputZipFile) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputZipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            File sourceFile = new File(sourceFolder);
            addFolderToZip("", sourceFile, zos);
        }
    }

    // Helper method to add files to the ZIP file
    private static void addFolderToZip(String path, File srcFolder, ZipOutputStream zos) throws IOException {
        if (srcFolder.isHidden()) {
            return;
        }
        if (srcFolder.isDirectory()) {
            if (!path.equals("")) {
                String subPath = path + "/" + srcFolder.getName();
                ZipEntry zipEntry = new ZipEntry(subPath + "/");
                zos.putNextEntry(zipEntry);
                zos.closeEntry();
            }
            for (File file : srcFolder.listFiles()) {
                addFolderToZip(path.equals("") ? srcFolder.getName() : path + "/" + srcFolder.getName(), file, zos);
            }
            return;
        }
        try (FileInputStream fis = new FileInputStream(srcFolder)) {
            ZipEntry zipEntry = new ZipEntry(path + "/" + srcFolder.getName());
            zos.putNextEntry(zipEntry);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
            zos.closeEntry();
        }
    }
}