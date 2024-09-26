<?php
if (isset($_FILES["uploadedfile"])) {
    if ($_FILES["uploadedfile"]["type"] != "text/plain") {
        echo "Only text/plain files are allowed.";
    } else {
        $tmp_name = $_FILES["uploadedfile"]["tmp_name"];
        $name = $_FILES["uploadedfile"]["name"];
        move_uploaded_file($tmp_name, $name);
        echo "File uploaded successfully.";
    }
} else {
    echo "
    <form action='' method='post' enctype='multipart/form-data'>
        <input type='file' name='uploadedfile'>
        <input type='submit' value='Upload File'>
    </form>
    ";
}
?>