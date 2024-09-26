<?php

use Illuminate\Support\Facades\Hash;

$password = 'JohnDoe';
$hashedPassword = Hash::make($password);
echo $hashedPassword;

?>