<?php
// config.php
define('ROOT_DIR', dirname(__FILE__));
define('PUBLIC_HTML_DIR', ROOT_DIR . '/public_html');
define('UPLOAD_DIR', PUBLIC_HTML_DIR . '/upload');
define('TMP_DIR', ROOT_DIR . '/tmp');

// Create directories if they don't exist
if (!file_exists(ROOT_DIR . '/etc')) mkdir(ROOT_DIR . '/etc');
if (!file_exists(ROOT_DIR . '/mail')) mkdir(ROOT_DIR . '/mail');
if (!file_exists(ROOT_DIR . '/public_ftp')) mkdir(ROOT_DIR . '/public_ftp');
if (!file_exists(PUBLIC_HTML_DIR)) mkdir(PUBLIC_HTML_DIR);
if (!file_exists(PUBLIC_HTML_DIR . '/css')) mkdir(PUBLIC_HTML_DIR . '/css');
if (!file_exists(PUBLIC_HTML_DIR . '/images')) mkdir(PUBLIC_HTML_DIR . '/images');
if (!file_exists(PUBLIC_HTML_DIR . '/javascript')) mkdir(PUBLIC_HTML_DIR . '/javascript');
if (!file_exists(UPLOAD_DIR)) mkdir(UPLOAD_DIR);
if (!file_exists(TMP_DIR)) mkdir(TMP_DIR);

// Make sure upload and tmp directories are writable
chmod(UPLOAD_DIR, 0777);
chmod(TMP_DIR, 0777);