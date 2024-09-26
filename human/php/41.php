<?php
$input = 'username'; // replace with your input
$cleanUsername = basename($input);
$filename      = '/path/to/password/files/' . $cleanUsername . '.txt';

if (file_exists($filename)) {
    echo "File exists!";
} else {
    echo "File does not exist!";
}
?>