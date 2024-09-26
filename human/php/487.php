<?php
function check_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $name      = check_input($_POST['name']);
  $email     = check_input($_POST['email']);
  $phone     = check_input($_POST['phone']);
  $subject   = check_input($_POST['subject']);
  $comments  = check_input($_POST['comments']);

  echo "Name: $name\n";
  echo "Email: $email\n";
  echo "Phone: $phone\n";
  echo "Subject: $subject\n";
  echo "Comments: $comments\n";
}
?>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
  Name: <input type="text" name="name">
  <br><br>
  Email: <input type="text" name="email">
  <br><br>
  Phone: <input type="text" name="phone">
  <br><br>
  Subject: <input type="text" name="subject">
  <br><br>
  Comments: <textarea name="comments"></textarea>
  <br><br>
  <input type="submit">
</form>