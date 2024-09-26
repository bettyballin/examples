<?php

// Require the Illuminate Hashing library
require 'vendor/autoload.php';

use Illuminate\Hashing\HashManager;

// Create a new HashManager instance
$hashManager = new HashManager(app('config')->get('hashing'));

// Hash the password
$hashedPassword = $hashManager->make('secret');

// Store $hashedPassword into database
echo $hashedPassword;