
$email = $_POST['email'];
$pass = $_POST['pass'];
$pass = md5($pass); // Note: Using MD5 for passwords is not secure.
$email = mysql_real_escape_string($email, $link); // This is the correct usage.

$sql = mysql_query("SELECT pass FROM users WHERE email='" . $email . "'", $link);
if ($row = mysql_fetch_array($sql)) {
    // ...
}

