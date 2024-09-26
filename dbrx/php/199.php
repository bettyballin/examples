<?php
$allowedDomains = ['example.com', 'sub.example.com'];
$currentDomain  = $_SERVER['HTTP_HOST'];

if (!in_array($currentDomain, $allowedDomains)) {
    header("Location: http://example.com/unauthorized");
    exit;
}
?>