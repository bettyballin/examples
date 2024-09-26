<?php
$page = preg_replace("/[^0-9]+/", "", $_GET['page']);
echo $page;
?>