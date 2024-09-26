<?php
$EmailFrom = "example@gmail.com";
$Subject = "";
$EmailTo = "recipient@example.com"; // added missing variable

// validation
$name = trim(stripslashes($_POST['name']));
$email = trim(stripslashes($_POST['email']));
$number = trim(stripslashes($_POST['tel']));

if (isset($_POST['submit'])) {
    if (!preg_match("/^[a-zA-Z ]*$/", $name) || !filter_var($email, FILTER_VALIDATE_EMAIL)){
        header("Location: error.php");
        exit;
    }

    if(isset($_POST['answer']) && $_POST['answer'] == 4){
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

        // send email
        if(mail($EmailTo, $Subject, $Body, "From: <$email>")){
            header("Location: success.php");
        } else {
            echo 'Failed to send the message';
        }
    }else{
        print "";
    }
}
?>