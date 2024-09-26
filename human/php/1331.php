<?php

// Set environment variable based on referer
if (isset($_SERVER['HTTP_REFERER']) && preg_match('/domain\.com/', $_SERVER['HTTP_REFERER'])) {
    putenv('is_local_referer=1');
}

// Check if file is a PDF and require local referer
if (preg_match('/\.pdf$/', $_SERVER['REQUEST_URI'])) {
    if (!getenv('is_local_referer')) {
        header('HTTP/1.1 403 Forbidden');
        exit;
    }
}

?>