<?php

// Only allow alphanumeric characters, underscores, dots, hyphens, forward slashes for directory traversal protection.
$allowed_chars = '/[^a-zA-Z0-9_\.\\-\s\/]/';
$file_path = './example.txt'; // replace with your file path
$filtered_file = preg_replace($allowed_chars, '', $file_path);

// Ensure the file path is within a specific root directory
$root_dir = realpath('/path/to/your/root/directory');
if (strpos(realpath($filtered_file), $root_dir) !== 0) {
    die('Invalid file path.');
}

// Now you can safely open or include files using $filtered_file.
echo "File path is valid: $filtered_file";

?>