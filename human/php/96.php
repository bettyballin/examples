<?php
/**
 * Restrict access to wp-login.php
 */

$order = 'Deny,Allow';
$deny = 'from all';
$allow = 'from Your.IP.Address';

$files = '<Files "wp-login.php">' . PHP_EOL;
$files .= '    Order ' . $order . PHP_EOL;
$files .= '    Deny ' . $deny . PHP_EOL;
$files .= '    Allow ' . $allow . PHP_EOL;
$files .= '</Files>';

echo $files;

// Create .htaccess file and write the rules
$file = '.htaccess';
if (!file_exists($file)) {
    $fp = fopen($file, 'w');
    fwrite($fp, $files);
    fclose($fp);
} else {
    $fp = fopen($file, 'a');
    fwrite($fp, $files);
    fclose($fp);
}