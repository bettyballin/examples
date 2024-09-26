<?php

function cleanMe($value) {
    return trim(htmlspecialchars($value));
}

$_GET = array_map('cleanMe', $_GET);
$_POST = array_map('cleanMe', $_POST);

print_r($_GET);
print_r($_POST);

?>