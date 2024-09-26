<?php
session_start();
// place anything you need to save between pages in $_SESSION
$_SESSION["foo"] = array("bar", "baz");
// until you unset $_SESSION["foo"], it will be available in every page that called
// session_start();
print_r($_SESSION["foo"]);
?>