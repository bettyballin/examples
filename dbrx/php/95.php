<?php
$file_name = $_FILES['file']['name'];
if (strpos($file_name, "\0") !== false || strpos($file_name, '%00') !== false) {
    echo "Error: Invalid file name.";
    exit;
}
?>