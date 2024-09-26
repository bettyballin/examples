<?php
$DBH = new mysqli("localhost", "username", "password", "database");

if ($DBH->connect_errno) {
  echo "Failed to connect to MySQL: (" . $DBH->connect_errno . ") " . $DBH->connect_error;
  exit();
}

$qSelect = $DBH->prepare('SELECT salt,password FROM users WHERE username = ?');
$qSelect->bind_param("s", $username);

$username = "your_username";
$pass = "your_password";

$qSelect->execute();
$qSelect->bind_result($salt, $db_password);
$qSelect->fetch();

if($salt == null){
  // username doesn't exist
  echo "Username does not exist";
  return;
}    

$hash = hash('sha256', $pass);
$hash = hash('sha256', $salt . $hash . $pass);  
if($hash == $db_password){
   echo "Login OK";
} else {
   echo "Login NOK";
}
?>