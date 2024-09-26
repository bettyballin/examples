<?php
if (isset($_GET['file']) && user_is_logged_in()) {
    $file = DIR_SOME_WHERE . '/' . basename($_GET['file']);
    if (file_exists($file) && user_has_file_access($file)) {
        header('Content-Description: File Transfer');
        header('Content-Type: application/octet-stream');
        header('Content-Disposition: attachment; filename=' . basename($file));
        header('Expires: 0');
        header('Cache-Control: must-revalidate');
        header('Content-Length: ' . filesize($file));
        ob_clean();
        flush();
        readfile($file);
        exit;
    }
}

// Assuming these functions are defined somewhere else in your code
function user_is_logged_in() {
    // Your logic to check if user is logged in
}

function user_has_file_access($file) {
    // Your logic to check if user has access to the file
}

define('DIR_SOME_WHERE', '/path/to/your/directory');
?>