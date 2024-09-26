<?php
// See the password_hash() example to see where this came from.
$hash = '$2y$07$BCryptRequires22Chrcte/VlQH0piJtjXl.0t1XkA8pw9dMXTpOq';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (password_verify($_POST['password'], $hash)) {
        echo 'Password is valid!';
    } else {
        echo 'Invalid password.';
    }
} else {
    echo '<form action="" method="post">
    <input type="password" name="password">
    <input type="submit">
    </form>';
}
?>