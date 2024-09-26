<?php
if (isset($_POST['submit'])) {
  $name = $_POST['name'];
  $email = $_POST['email'];
  $phone = $_POST['phone'];
  $subject = $_POST['subject'];
  $comments = $_POST['comments'];

  if ($name && $email && $phone && $subject && $comments) {
    $to = "your_email@example.com";
    $message = "
      Name: $name
      Email: $email
      Phone: $phone
      Subject: $subject
      Comments: $comments
    ";
    $headers = "From: $email";
    mail($to, $subject, $message, $headers);
    echo "Thank you for contacting us!";
  } else {
    echo "Please fill out all fields.";
  }
}
?>

<form action="" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name"><br><br>
  <label for="email">Email:</label>
  <input type="email" id="email" name="email"><br><br>
  <label for="phone">Phone:</label>
  <input type="text" id="phone" name="phone"><br><br>
  <label for="subject">Subject:</label>
  <input type="text" id="subject" name="subject"><br><br>
  <label for="comments">Comments:</label>
  <textarea id="comments" name="comments"></textarea><br><br>
  <input type="submit" name="submit" value="Submit">
</form>