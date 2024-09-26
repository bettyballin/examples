<?php
// Define a constant for the root directory path (e.g in config.php)
define('ROOT_DIR', dirname(__DIR__));

// Then use ROOT_DIR to include files securely
require_once(ROOT_DIR . '/file.php');