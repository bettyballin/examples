<?php
function check_hash($hash, $existing_hash) {
    if($hash === $existing_hash)
    {
        return true;
    }
    else
    {
        return false;
    }
}

// Example usage:
$hash = "example_hash";
$existing_hash = "example_hash";

$result = check_hash($hash, $existing_hash);
var_dump($result);
?>