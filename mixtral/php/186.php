<?php
$title = "Test Title";
$price = 10.99;
$detail = "This is a test detail";

$title = htmlspecialchars($title, ENT_QUOTES);
$price = htmlspecialchars($price, ENT_QUOTES);
$detail = htmlspecialchars($detail, ENT_QUOTES);

echo $title;
echo "\n";
echo $price;
echo "\n";
echo $detail;
?>