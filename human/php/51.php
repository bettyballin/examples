/var/example.com:
    include/
        config.php
        helper_blah.php
    webroot/
        index.php
        view.php

// config.php
<?php
define('DB_HOST', 'localhost');
define('DB_USER', 'username');
define('DB_PASSWORD', 'password');
define('DB_NAME', 'database');
?>

// helper_blah.php
<?php
function blah_helper() {
    echo "Hello, World!";
}
?>

// index.php
<?php
require_once '../include/config.php';
require_once '../include/helper_blah.php';

blah_helper();
?>

// view.php
<?php
require_once '../include/config.php';
require_once '../include/helper_blah.php';

echo "View page";
?>