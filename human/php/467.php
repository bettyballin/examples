<?php
$allowed_pages = array('index', 'test', 'my_page');
if (!in_array($_GET['page'], $allowed_pages)){
    echo 'good bye';
    die();
} else {
    // your code here
}
?>