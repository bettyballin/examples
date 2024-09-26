<?php
$dbh = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

$sth = $dbh->prepare("SELECT * FROM mmh_user_info WHERE email_address = ?");
$sth->execute(array($_REQUEST['email_address']));
$red = $sth->fetchAll();

print_r($red);
?>