<?php

  //Get Post Variables. The name is the same as 
  //what was in the object that was sent in the jQuery

  if (isset($_POST['messageid'])) {
      include 'db_connect.php';
      session_start();
      $usermsg = $_SESSION['username'];
      $message_id = $_POST['messageid'];
      mysql_query("UPDATE messages SET message_read='1' WHERE id='$message_id' AND to_user='$usermsg'");
  }

?>