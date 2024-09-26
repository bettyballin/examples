<?php
  if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);
    echo $name;
  }
?>

<form action="" method="post">
  <input type="text" name="name" placeholder="Enter your name">
  <input type="submit" value="Submit">
</form>