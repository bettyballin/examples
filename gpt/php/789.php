
   // Assuming $mysqli is your MySQLi database connection object
   $stmt = $mysqli->prepare("INSERT INTO comments (comment) VALUES (?)");
   $stmt->bind_param('s', $comment);
   $comment = $_POST['comment']; // The user's input
