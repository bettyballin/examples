<?php
$text = "Hello, World!";
$password = "mysecretpassword";
$username = "john_doe";

$url = "http://example.com/foo.php?text=".$text."&password=".md5($password)."&username=".$username;

echo $url;
?>