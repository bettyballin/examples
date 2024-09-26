<?php
if(isset($_POST['submit'])){
  if (strcmp('serenity', strtolower(str_replace(' ', '', trim($_POST['user_proof'])))) == 0) {
    echo "Correct!";
  } else {
    echo "Incorrect!";
  }
}
?>

<form action="" method="post">
  <input type="text" name="user_proof">
  <input type="submit" name="submit" value="Submit">
</form>