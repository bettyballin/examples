<?php
$db = new PDO('mysql:host=localhost;dbname=test', 'username', 'password');
$db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
?>