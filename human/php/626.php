<?php
$_SERVER['REQUEST_URI'] = '/path/to/your/script.php';
$_SERVER['REQUEST_URI_PATH'] = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);
print_r($_SERVER['REQUEST_URI_PATH']);
?>