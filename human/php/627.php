<?php
$basedir = __DIR__;
$path = realpath($basedir . $_SERVER['REQUEST_URI']);
if ($path && strpos($path, $basedir) === 0) {
    include $path;
}
?>