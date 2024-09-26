<?php
$pages = array('about','contact','home');

$p = isset($_GET['p']) && in_array($_GET['p'], $pages)? $_GET['p'] : 'home';
include "includes/{$p}.php";
?>