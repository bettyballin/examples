<?php
// PHP service file

// Get all data coming in via GET or POST
$vars = $_GET + $_POST;

// Do something with the data coming in
print_r($vars);
?>