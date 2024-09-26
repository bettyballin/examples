
<?php

// Set to true to prevent collision with already existing session IDs
ini_set('session.use_strict_mode', 1);

// A variable to store generated session IDs
$session_ids = array();

// The number of session IDs you want to generate
$number_of_ids_to_generate = 100000; // Adjust this to your needs

// Counter for collisions
$collisions = 0;

for ($i = 0; $i < $number_of_ids_to_generate; $i++) {
    // Generate a new session ID
    $new
