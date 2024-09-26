<?php

$columns = array('user_name', 'email', 'phone'); // assuming these are your columns

$order_by = 'user_name';
if (isset($_GET['order_by']) && array_search($_GET['order_by'], $columns) !== false) {
    $order_by = $_GET['order_by'];
}

$order_dir = 'ASC';
if (isset($_GET['order_dir']) && strtoupper($_GET['order_dir']) == 'DESC') {
    $order_dir = 'DESC';
}

// for testing purposes
echo "Order by: $order_by\n";
echo "Order direction: $order_dir\n";

?>