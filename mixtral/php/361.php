<?php

$expected_value = 'your_secret_value_here';

if (isset($_SERVER['HTTP_SECRET']) && $_SERVER['HTTP_SECRET'] !== $expected_value) {
    exit();
}
// rest of the script

?>