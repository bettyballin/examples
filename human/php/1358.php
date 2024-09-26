<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") { 

    $user_subject = strip_tags(trim($_POST['subject']));
    $user_message = strip_tags(trim($_POST['message']));

    $send_to = 'myemail@gmail.com';

    mail($send_to, $user_subject, $user_message);

} else {
    echo 'form not filled';
}
?>