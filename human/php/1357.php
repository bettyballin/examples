<?php

// Check if the form has been submitted
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Get the user's input
    $user_subject = $_POST['subject'];
    $user_message = $_POST['message'];

    // Set the recipient's email address
    $send_to = 'myemail@gmail.com';

    // Send the email
    mail($send_to, $user_subject, $user_message);
}

?>
<form action="" method="post">
    <label for="subject">Subject:</label>
    <input type="text" id="subject" name="subject"><br><br>
    <label for="message">Message:</label>
    <textarea id="message" name="message"></textarea><br><br>
    <input type="submit" value="Send Email">
</form>