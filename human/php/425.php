<?php
$hash = "precomputed hash of your password";

if (isset($_POST['password'])) {
    if (crypt($_POST['password'], '$6$rounds=5000$usesomesillystringforsalt$') == $hash)  {
        echo "Password is valid";
    } else {
        echo "Password is not valid";
    }
} else {
    echo "Please enter a password";
}
?>
<form action="" method="post">
    <input type="password" name="password" placeholder="Enter password">
    <input type="submit" value="Submit">
</form>