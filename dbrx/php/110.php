<?php
function safeResolvePath($path) {
    $components = explode('/', $path);
    $resolved = array();
    foreach ($components as $component) {
        if ($component === '..') {
            array_pop($resolved);
        } elseif ($component !== '' && $component !== '.') {
            $resolved[] = $component;
        }
    }
    $resolvedPath = implode('/', $resolved);
    if (substr($path, 0, 1) === '/') {
        return '/' . $resolvedPath;
    } else {
        return $resolvedPath;
    }
}

echo safeResolvePath('path/../../to/some/../relative/file.txt');
?>