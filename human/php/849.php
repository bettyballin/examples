<?php
if(isset($_GET['file'])) 
{
    // sanitize request and keep just the name and extension
    $file_path  = $_GET['file'];
    $path_parts = pathinfo($file_path);
    $file_name  = $path_parts['basename'];
    $file_ext   = $path_parts['extension'];

    // replaces the file location with a preset one
    $file_path  = '/home/test/db-backups/'.$file_name;

    // make sure the file exists
    if (is_file($file_path))
    {
        // send the right headers
        header('Content-Type: application/octet-stream');
        header('Content-Disposition: attachment; filename="'.$file_name.'"');
        header('Content-Length: '.filesize($file_path));

        // send the file contents
        readfile($file_path);
        exit;
    }
    else
    {
        echo "File not found.";
    }
}
else
{
    echo "No file specified.";
}
?>