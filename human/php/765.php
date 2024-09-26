<?php
$file = 'path_to_your_file.txt'; // replace with your file path
$id = 1; // replace with your id

$conn = new mysqli("localhost", "username", "password", "database");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "UPDATE `novels` SET `size`=".filesize($file)." WHERE `id`=".(int)$id;

if ($conn->query($sql) === TRUE) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . $conn->error;
}

$conn->close();
?>