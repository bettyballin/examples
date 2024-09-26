<?php
$kit = 'your_post_id';
$personid = 'your_person_id';

$conn = new mysqli('your_host', 'your_username', 'your_password', 'your_database');

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql="SELECT `Who_can_see` from `posts`
      where `post_id` = '$kit'
        AND `Who_can_see` = '$personid'";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo $row["Who_can_see"];
    }
} else {
    echo "0 results";
}

$conn->close();
?>