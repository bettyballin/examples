<?php
session_start();

$item_id = 1; // example item id
$quantity = 2; // example quantity

$_SESSION["shoppingCart"] = array(
   $item_id => $quantity
);

print_r($_SESSION["shoppingCart"]);
?>