<?php

use Illuminate\Support\Facades\Hash;

$password = $_POST['passwordformfield']; 
$hashed = Hash::make($password);

echo $hashed;

?>