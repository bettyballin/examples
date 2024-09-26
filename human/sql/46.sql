php
<?php
session_start();
$registerkey = 'your_register_key_here';
$_SESSION['register_token']=sha1(uniqid(rand(), TRUE).$registerkey);
echo $_SESSION['register_token'];
?>