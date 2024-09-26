// At the top level file e.g in your `index.php`
define('ABSPATH', dirname(__FILE__));
require 'header.php';

// In your `header.php`
defined('ABSPATH') or die("Access denied");