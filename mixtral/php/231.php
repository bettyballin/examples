<?php
  if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = htmlspecialchars($_POST['username'], ENT_QUOTES);
    echo $username;

    // or

    $message = htmlentities($_POST['message']);
    echo $message;
  }
?>

<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
  Username: <input type="text" name="username">
  <br><br>
  Message: <textarea name="message"></textarea>
  <br><br>
  <input type="submit" name="submit" value="Submit">
</form>