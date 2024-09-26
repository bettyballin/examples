<?php

$db = new sitedatalayer();

if ($stmt = $db->_conn->prepare("SELECT `salt` FROM admins WHERE `username` = ? LIMIT 1")) {

  $username = 'your_username'; // replace with actual username
  $stmt->bindValue(1, $username, PDO::PARAM_STR);
  $stmt->execute();

  $row = $stmt->fetch(PDO::FETCH_ASSOC);

  if ($row) {
    $salt = $row['salt'];
    // do something with the salt
    echo $salt;
  }

}

class sitedatalayer {
  public $_conn;

  function __construct() {
    $this->_conn = new PDO('mysql:host=your_host;dbname=your_db', 'your_username', 'your_password');
  }
}