<?php

function Query($sql) {
  $conn = mysql_connect("localhost", "username", "password");
  mysql_select_db("database", $conn);
  $result = mysql_query($sql, $conn);
  return $result;
}

function authorize($user_id, $clearance) {
  // coerce to integer to defend against SQL Injection
  $user_id = (int) $user_id;

  $sql = "SELECT status, level FROM users WHERE id = {$user_id}";
  $userData = mysql_fetch_array(Query($sql));

  $tally = 0;
  foreach ((array) $clearance as $userStatus) {
    if (is_numeric($userStatus)) {
      $tally += ($userData["level"] <= $userStatus);
    } else {
      $tally += ($userData["status"] == $userStatus);
    }
  }

  return $tally;
}

// Example usage
$user_id = 1;
$clearance = array("admin", 5);
echo authorize($user_id, $clearance);

?>