<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") { 

    $user_subject = strip_tags(trim($_POST['subject']));
    $user_message = strip_tags(trim($_POST['message']));

    $send_to = 'myemail@gmail.com';

    mail($send_to, $user_subject, $user_message);

}

?>

<html>
    <head></head>
    <body>
        <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
            <input type="text" name="subject" />
            <textarea name="message"></textarea>
            <button type="submit">Send</button>
        </form>
    </body>
</html>