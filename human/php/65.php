<?php
$allow = array('home', 'about', 'contact'); // Replace with your allowed pages

if (empty($_GET['page']) || empty($allow[$_GET['page']]) || ($_GET['page'] == 'home'))
{
    // Technically a header location should be a complete URL - http://...
    header("Location: home.php");
    exit();
}
?>