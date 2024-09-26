<?php
$image_file = 'your_image_file.jpg'; // replace with your image file
$gallery_id = 1; // replace with your gallery id
$_SESSION['user_id'] = 1; // replace with your user id

$conn = new mysqli("localhost", "username", "password", "database");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO images (gallery_id, image_file) 
        SELECT id, '$image_file'
        FROM Galleries 
        WHERE id = $gallery_id AND user_id = {$_SESSION['user_id']}";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>