<?php
$pass = 'your_password';
$cryptedPass = crypt($pass, 'your_salt');

if($cryptedPass==crypt($pass,$cryptedPass)) {
    echo 'Yeah!';
}
?>