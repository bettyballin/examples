This is not PHP code, it's Apache mod_rewrite configuration. Here is the equivalent PHP code using a simple routing mechanism:


<?php
$uri = $_SERVER['REQUEST_URI'];
if (preg_match('/^\/images\b.*$/', $uri)) {
    $newUri = 'index.php' . $uri;
    header('Location: ' . $newUri);
    exit;
}
?>