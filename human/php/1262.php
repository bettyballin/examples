<?php

// Just in case there's more than one ...
$domains = ['abc.example.com', 'foo.bar.baz'];
if ( ! in_array($_SERVER['SERVER_NAME'], $domains)) {
    die('Error: This script can only be run on ' . implode(', ', $domains));
}

?>