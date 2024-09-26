<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_FILES["fileToUpload"]) && $_FILES["fileToUpload"]["error"] == 0) {
        $targetDir = "uploads/";

        // Generate a unique filename to prevent overwriting existing files
        $fileName = uniqid() . "_" . basename($_FILES['fileToUpload']['name']);

        if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $targetDir.$fileName)) {
            echo "File upload successful.";
        } else {
            echo "Error: Unable to move the file to the target directory";
        }
    }
}
?>

<!DOCTYPE html>
<html lang="en">
  <head>
      <!-- Ensure your form uses method POST and enctype multipart/form-data -->
      <meta charset="UTF-8" />
      <title>Secure File Upload</title>
  </head>

  <body>
    <h1>Upload a file securely:</h1>

    <!-- Ensure your form uses method POST and enctype multipart/form-data -->

    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post" enctype="multipart/form-data">
      Select image to upload:

        <input type="file" name="fileToUpload" id="fileToUpload"><br><br>

          <!-- Add a submit button -->

            <button type="submit" value="Submit" name="uploadBtn">
              Upload
            </button>
    </form>
  </body>
</html>