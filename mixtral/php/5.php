<?php
$allowed_pages = ['page1', 'page2'];
if (isset($_GET['page']) && in_array($_GET['page'], $allowed_pages)) {
    include $_GET['page'] . '.php';
} else {
   die('Invalid page');
}
?>