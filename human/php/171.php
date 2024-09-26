<?php
  $name = 'John Doe'; // example value for $name
  $conn = new mysqli('localhost', 'username', 'password', 'database');
  
  if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
  }
  
  $query = 'SELECT * FROM users WHERE name="' . mysqli_real_escape_string($conn, $name) . '"';
  
  $result = $conn->query($query);
  
  if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
      echo $row['name'] . '<br>';
    }
  } else {
    echo "0 results";
  }
  
  $conn->close();
?>