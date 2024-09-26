<?php
$salt = 'some2%string!!here1';
if (isset($_POST['password'])) {
    $hash = sha1($salt . $_POST['password']);
    echo $hash;
} else {
    echo "No password provided";
}
?>

<form action="" method="post">
    <input type="password" name="password" placeholder="Enter password">
    <input type="submit" value="Submit">
</form>