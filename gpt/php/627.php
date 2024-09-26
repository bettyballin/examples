
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get form fields and remove whitespace
    $name = trim($_POST["name"]);
    $email = trim($_POST["email"]);
    $number = trim($_POST["number"]);
    $message = trim($_POST["message"]);
    $answer = isset($_POST["answer"]) ? trim($_POST["answer"]) : '';

    // Define the email to which the form will be sent
    $EmailTo = "your-email@example.com";
    $Subject = "New Message Received";

    // Check if the security question is answered correctly
    if ($answer != '4') {
        // The answer is incorrect, redirect to error page or handle the error
        header('Location: error.php');
        exit;
    }

    // If the answer is correct, prepare the email body text
    $Body = "";
    $Body .= "Name: ";
    $Body .= $name;
    $Body .=
