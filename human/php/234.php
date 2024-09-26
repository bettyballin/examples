<?php

// Create table
$sql = "
    CREATE TABLE `test` (
       `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
       `stuff` BLOB NOT NULL DEFAULT ''
    );
";

// Connect to database
$conn = new mysqli("localhost", "username", "password", "database");

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Execute create table query
if ($conn->query($sql) === TRUE) {
    echo "Table created successfully\n";
} else {
    echo "Error creating table: " . $conn->error . "\n";
}

// Insert data
$sql = "
    INSERT INTO test (stuff) VALUES (AES_ENCRYPT('My hovercraft is full of eels!', 'password'));
";

if ($conn->query($sql) === TRUE) {
    echo "Data inserted successfully\n";
} else {
    echo "Error inserting data: " . $conn->error . "\n";
}

// Select data
$sql = "
    SELECT AES_DECRYPT(stuff, 'password') AS stuff FROM test;
";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo "Stuff: " . $row["stuff"] . "\n";
    }
} else {
    echo "No results\n";
}

$conn->close();

?>