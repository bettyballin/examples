<?php

// Get the raw input from the HTTP request
$input = file_get_contents('php://input');

// Decode the JSON data
$data = json_decode($input, true);

// Print the decoded data
print_r($data);

?>