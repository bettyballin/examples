<?php
ini_set('user_agent', "PHP\r\nX-MyCustomHeader: Foo");

$fp = fopen('http://www.example.com/index.php', 'r');
fpassthru($fp);
fclose($fp);
?>