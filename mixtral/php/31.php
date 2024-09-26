<?php

// Configuration
$dbHost = 'your_host';
$dbName = 'your_database';
$dbUser = 'your_username';
$dbPass = 'your_password';

// Create PDO instance
$db = new PDO("mysql:host=$dbHost;dbname=$dbName", $dbUser, $dbPass);
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

// Check token
if (isValidToken($_GET['token'])) {
  // Serve file
  echo "Token is valid.";
} else {
  header('HTTP/1.0 403 Forbidden');
  exit;
}

function isValidToken($token)
{
  global $db;

  $query = "SELECT COUNT(*) FROM tokens WHERE token=:token";

  try
  {
    // Prepare statement
    $stmt = $db->prepare($query);

    // Bind parameters
    $stmt->bindParam(':token', $token, PDO::PARAM_STR);

    // Execute the query
    $stmt->execute();
    $row = $stmt->fetch();

    if ($row['COUNT(*)'] > 0)
      return true;
  }

  catch (PDOException $e)
  {
    echo "Error: " . $e->getMessage()."<br>";

    // Log error
    error_log($e->getMessage());

    exit();
  }

  return false;
}

?>