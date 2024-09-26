// index.php:
<?php
define('INDEX_LOADED', true);
require_once 'includes/addpage.php';
?>

// /includes/addpage.php:
<?php
if (!defined('INDEX_LOADED')) die('no direct access allowed');
echo "Add page loaded successfully.";
?>