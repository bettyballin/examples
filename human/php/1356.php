<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $subject = $_POST['subject'];
    $message = $_POST['message'];
    $to = 'your_email@example.com'; // replace with your email
    $headers = 'From: your_email@example.com' . "\r\n" .
        'Reply-To: your_email@example.com' . "\r\n" .
        'X-Mailer: PHP/' . phpversion();

    mail($to, $subject, $message, $headers);
    echo "Email sent successfully!";
}
?>

<html>
    <head></head>
    <body>
        <form action="<?php echo $_SERVER["PHP_SELF"]; ?>" method="post">
            <input name="subject" />
            <textarea name="message"></textarea>
            <button>Send</button>
        </form>
    </body>
</html>