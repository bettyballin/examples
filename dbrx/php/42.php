<?php
$allowed_files = [
    'page1' => '/path/to/page1.php',
    'page2' => '/path/to/page2.php'
];

$file_name = basename($_SERVER['REQUEST_URI']);
if (isset($allowed_files[$file_name])) {
    include $allowed_files[$file_name];
} else {
    echo "Error: Page not found.";
}
?>