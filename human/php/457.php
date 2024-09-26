<?php
$yourImportantVar = 'Something relies on this';

// Simulating user POST request
$_POST = array('yourImportantVar' => 'overwritten');

foreach ($_POST as $key => $value) {
    $$key = $value; 
}
echo $yourImportantVar; // outputs: overwritten
?>