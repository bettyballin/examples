<?php
$_GET["page"] = "  9999  ";
$name = filter_var($_GET["page"], FILTER_VALIDATE_INT);
var_dump($name);
?>