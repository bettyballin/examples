<?php
$path = '/path/to/some/file.txt'; // replace with your path
$root = '/path/to/root'; // replace with your root directory

$dir = $path;
$found = false;

while ($dir) {
    $dir = dirname($dir);
    if (!is_dir($dir)) {
        continue;
    }

    if (strpos(realpath($dir), $root) === 0) {
        $found = true;
    }

    break;
}

var_dump($found);
?>