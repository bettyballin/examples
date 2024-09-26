<?php
define('IS_INCLUDED', true);
require_once 'class.php';
$x = new Class();
$valid_pages = array('home', 'about', 'contact');
$page = $_GET['page'];
if (isset($page) && file_exists($page . '.php') && in_array($page, $valid_pages)) {
    include $page . '.php';
} else {
    include '404.php';
}
?>