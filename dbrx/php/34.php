<?php

if ($_SERVER['REMOTE_ADDR'] !== '127.0.0.1' || php_sapi_name() !== 'cli') {
    die('Access denied');
}

echo "Hello, World!";