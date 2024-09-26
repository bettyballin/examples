<?php
$host = 'your_host';
$username = 'your_username';
$password = 'your_password';
$database = 'your_database';

$mysqli = new mysqli($host, $username, $password, $database);

if ($stmt = $mysqli->prepare('SELECT * FROM users WHERE id=? AND check=?')) {

    // Bind parameters (s = string, i = integer)
    $id = $_GET['id'];
    $check = $_POST['check'];
    $stmt->bind_param("ii", $id, $check);

    if ($stmt->execute()) {

        /* Store result */
        $result = $stmt->get_result();

        while($row = $result->fetch_assoc()){
            // Do something with the row
            print_r($row);
        }

    } else {
        echo "Execute failed: (" . $mysqli->errno . ") " . $mysqli->error;
    }

    $stmt->close();
} else {
    echo "Prepare failed: (" . $mysqli->errno . ") " . $mysqli->error;
}

$mysqli->close();
?>