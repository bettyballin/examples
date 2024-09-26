<?php
/*
In case there is no PHP, deny access to php files (for safety)
*/
if (!extension_loaded('php5_module')) {
    if (preg_match('/\.(php|phtml)$/', $_SERVER['REQUEST_URI'])) {
        header('HTTP/1.1 403 Forbidden');
        exit('Access Denied');
    }
}

/*
the following should be added if you want to parse .php and .phtml file as PHP
.phps will add syntax highlighting to the file when requesting it with a browser
*/
if (extension_loaded('php5_module')) {
    header('Content-Type: text/html');
    $extensions = array('.php', '.phtml', '.phps');
    if (in_array(substr($_SERVER['REQUEST_URI'], -4), $extensions)) {
        // Handle as PHP
    } elseif (substr($_SERVER['REQUEST_URI'], -5) === '.phps') {
        highlight_file($_SERVER['SCRIPT_FILENAME']);
        exit;
    }
}
?>