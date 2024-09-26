<?php

$uri = $_SERVER['REQUEST_URI'];

if (strpos($uri, '//') !== false) {
    $uri = str_replace('//', '/', $uri);

    header("Location: $uri");
    exit;
}