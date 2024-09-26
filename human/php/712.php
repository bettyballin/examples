<?php

if (isset($_SERVER['REQUEST_FILENAME']) && is_file($_SERVER['REQUEST_FILENAME'])) {
    if (preg_match('/\..+[\s?]/', $_SERVER['REQUEST_URI'])) {
        if (!preg_match('/\.(?:jpe?g|gif|bmp|png|tiff|css|js)$/', $_SERVER['REQUEST_URI'])) {
            header('HTTP/1.0 403 Forbidden');
            exit;
        }
    }
}

?>