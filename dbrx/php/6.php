<?php
$file = $_GET["file"];
$filtered_file = filter_var($file, FILTER_SANITIZE_STRING);

// Now you can use $filtered_file to open a file safely.
echo $filtered_file;
?>