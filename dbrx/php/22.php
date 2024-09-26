// In file_one.php

define('ALLOWED_FILE', __FILE__);
define('ROOTPATH', dirname(__FILE__));

require_once(ROOTPATH . '/file_two.php');

// In file_two.php

if (!defined('ALLOWED_FILE') || $_SERVER['SCRIPT_FILENAME'] !== ALLOWED_FILE) {
    exit;
}