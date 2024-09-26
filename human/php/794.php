<?php
if( !empty( $_POST['answer'] ) && $_POST['answer'] == 4) {
     // send email 
     $EmailTo = "example@example.com"; // replace with recipient email
     $Subject = "Email Subject"; // replace with email subject
     $Body = "Email Body"; // replace with email body
     $email = "your_email@example.com"; // replace with sender email
     $submit = mail($EmailTo, $Subject, $Body, "From: <$email>");
} else {
     // Set error
     echo "Verification failed.";
}
?>