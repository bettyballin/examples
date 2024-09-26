<?php
$password = 'your_password_here';
$randomword = 'your_random_word_here';
$username = 'your_username_here';

$message = NULL;
if (isset($_COOKIE['MyLoginPage'])) {
    if ($_COOKIE['MyLoginPage'] == md5($password . $randomword)) {
        ?>
        CONTENT HERE
        <?php
        exit;
    } else {
        $message = "<p>Bad cookie. Clear please clear them out and try to login again.</p>";
    }
}

if (isset($_GET['p']) && $_GET['p'] == "login") {
    if ($_POST['name'] != $username) {
        $message = "<p>Sorry, that username does not match. Use your browser back button to go back and try again.</p>";
    } else if ($_POST['pass'] != $password) {
        $message = "<p>Sorry, that password does not match. Use your browser back button to go back and try again.</p>";
    } else if ($_POST['name'] == $username && $_POST['pass'] == $password) {
        setcookie('MyLoginPage', md5($_POST['pass'] . $randomword));
        header("Location: $_SERVER[PHP_SELF]");
    } else {
        $message = "<p>Sorry, you could not be logged in at this time. Refresh the page and try again.</p>";
    }
}
?>

<form action="<?php echo $_SERVER['PHP_SELF']; ?>?p=login" method="post">
    <fieldset>
        <label><input type="text" name="name" id="name" /> Name</label>
        <br />
        <label><input type="password" name="pass" id="pass" /> Password</label>
        <br />
        <input type="submit" id="submit" value="Login" />
    </fieldset>
    <?php
    if (isset($message)) {
        echo "<div>" . $message . "</div>";
    }
    ?>
</form>