<?php
$fileName = $_FILES["file"]["name"];

if(!preg_match ( '/\\.(gif|p(sd|ng)|tiff?|jpg)$/' , $fileName)){
    header("415 Unsupported Media Type");
    die("File type not allowed.");
} else {
    echo "File type allowed.";
}
?>
<form action="" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="Upload">
</form>