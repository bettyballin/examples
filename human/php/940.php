<?php
$dbConnection = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');
$dbConnection->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
$dbConnection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
?>