<?php
$entries = array_map(function($x) {
    return htmlentities($x, ENT_QUOTES);
}, $_POST['entries']);

print_r($entries);
?>