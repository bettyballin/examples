<?php

function sanitizePath($path) {
    $components = explode('/', trim($path, '/'));
    $sanitizedComponents = [];

    foreach ($components as $component) {
        if (empty($component) || $component === '.' || strpos($component, '..') !== false) {
            continue;
        }
        $sanitizedComponents[] = $component;
    }

    return implode('/', $sanitizedComponents);
}

$path = sanitizePath('path/to/file');
$filename = 'example.txt'; // assuming a filename
$handle  = fopen($path . '/' . $filename, 'r');

// Example usage:
if ($handle) {
    echo "File opened successfully.";
    fclose($handle);
} else {
    echo "Error opening the file.";
}

?>