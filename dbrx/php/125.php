<?php

// set error message and exit if verification question is incorrect or form values missing
if (!isset($_POST['answer']) || $_POST['answer'] != 4) {
    header('Location: error.php');
    exit;
}

$name = trim(stripslashes(htmlspecialchars($_POST['name'])));
$email = trim(stripslashes(htmlspecialchars($_POST['email'])));
$number = trim(stripslashes(htmlspecialchars($_POST['number'])));
$message = trim(stripslashes(htmlspecialchars($_POST['message'])));

if (empty($name) || empty($email) || !filter_var($email, FILTER_VALIDATE_EMAIL)) {
    header('Location: error.php');
    exit;
}

// prepare email body text
$Body = "";
$Body .= "Name: ";
$Body .= $name;
$Body .= "\n";
$Body .= "Tel: ";
$Body .= $number;
$Body .= "\n";
$Body .= "Email: ";
$Body .= $email;
$Body .= "\n";
$Body .= "Message: ";
$Body .= $message;
$Body .= "\n";

// send email
$EmailTo = 'your_email@example.com'; // replace with your email address
$Subject = 'Form Submission';
$submit = mail($EmailTo, $Subject, $Body, "From: <{$email}>");

// redirect to success page
if ($submit) {
    header('Location: success.php');
    exit;
}

?>