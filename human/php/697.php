<?php

session_start();

if (isset($_POST['message']))
{
    if (isset($_SESSION['token']) && $_POST['token'] == $_SESSION['token'])
    {
        $message = htmlentities($_POST['message']);

        $fp = fopen('./messages.txt', 'a');
        fwrite($fp, "$message<br />");
        fclose($fp);
    }
}

$token = md5(uniqid(rand(), true));
$_SESSION['token'] = $token;

?>

<form method="POST">
    <input type="hidden" name="token" value="<?php echo $token; ?>" />
    <input type="text" name="message"><br />
    <input type="submit">
</form>

<?php

readfile('./messages.txt');

?>