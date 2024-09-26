<?php
$realPath = realpath('path/to/your/wp/installation');
$needle = "/gzinflate/";
$di = new RecursiveDirectoryIterator($realPath);
foreach (new RecursiveIteratorIterator($di) as $file) {
    $haystack = file_get_contents($file->getPathname());
    if(preg_match_all($needle, $haystack, $matches)) {
        echo $file->getPathname();
        echo "\n";
    }
}
?>