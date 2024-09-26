<?php

$currentPage = \Classes\stdlib::GetVariable("view");
$isAdmin = isset($_GET["admin"]);
$view = "";
$content = null;
$allowedViews = array("Admin", "Brukere", "Fag", "Fravær", "Kontakt", "Login", "Profil", "Registrer");

if (in_array($currentPage, $allowedViews) && class_exists("\\Views\\{$currentPage}")) {
    $view = "\\Views\\{$currentPage}";
    $content = new $view();
}

?>