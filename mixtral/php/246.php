<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $number = $_POST['number'];

  if (filter_var($number, FILTER_VALIDATE_INT)) {
    $sanitizedNumber = preg_replace("/[^0-9]/", "", $number);

    // Put sanitized number in database
  } else {
    echo "Invalid input";
  }
}
?>
<form method="post">
  <input type="text" name="number">
  <input type="submit">
</form>