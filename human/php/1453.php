<?php
$uri = $_SERVER['REQUEST_URI'];
if (preg_match('/^\/(logout|login|_(wdt|profiler))/', $uri)) {
    return;
}