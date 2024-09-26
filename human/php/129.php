<?php
$salt = 'your_secret_salt_here'; // replace with your secret salt

if(get_magic_quotes_gpc()){
   $user = stripslashes($_POST['user']);
   $pass = stripslashes($_POST['pass']);
} else {
   $user = $_POST['user'];
   $pass = $_POST['pass'];
}

$user = mysql_real_escape_string($user);
$pass = hash('sha256', $salt.$pass);

// your database connection and query code here
?>