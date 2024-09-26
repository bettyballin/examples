<?php
function user($user_id = FALSE) {
   if ($user_id !== FALSE) {
      // assuming you are using a database to store user data
      $conn = mysqli_connect("localhost", "username", "password", "database");
      $query = "SELECT * FROM users WHERE id = '$user_id'";
      $result = mysqli_query($conn, $query);
      $user_data = mysqli_fetch_assoc($result);
      return $user_data;
   } else {
      return "No user ID provided";
   }
}

// example usage
$user_id = $_SERVER['REQUEST_URI'];
$user_id = explode('/', $user_id);
$user_id = $user_id[3]; // assuming URL structure: domain.com/path/to/user/123

$user_data = user($user_id);
print_r($user_data);
?>