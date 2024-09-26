<?php
$mysqli = new mysqli("localhost", "username", "password", "database");

if ($mysqli->connect_errno) {
    printf("Connect failed: %s\n", $mysqli->connect_error);
    exit();
}

$lastmsg = 100; // example value

$stmt = $mysqli->prepare("SELECT * FROM updates WHERE item_id < ? ORDER BY item_id DESC LIMIT 16");
$stmt->bind_param('i', $lastmsg);
$stmt->execute();
$result = $stmt->get_result();

while ($row = $result->fetch_assoc()) {
    $msg_id = $row['item_id'];
    $message = $row['item_content'];
    echo "Message ID: $msg_id, Message: $message\n";
}

$stmt->close();
$mysqli->close();
?>