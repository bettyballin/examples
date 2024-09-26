<?php
$secretKey = 'your_long_random_string';
$requestParams = http_build_query(array('id' => 1234));
$hashFromUrl = $_GET['hash'];
?>