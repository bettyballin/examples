<?php
// /home/you/www/config.php
define('PUBLIC_DIR', '/home/you/www/public/');
define('PRIVATE_DIR', '/home/you/www/');

// /home/you/www/public/index.php
require_once PRIVATE_DIR . 'vendor/autoload.php';
require_once PRIVATE_DIR . 'config.php';

// Rest of your code...