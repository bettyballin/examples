<?php

// Security settings
$securitySettings = array(
    'show_source' => 'Off',
    'display_ini_files' => 'Off',
    'allow_directory_listing' => 'Off',
    'index_file' => 'index.php'
);

// Write security settings to php.ini file
$iniFile = 'php.ini';
$fileHandle = fopen($iniFile, 'w');

// Write security settings to file
fwrite($fileHandle, "[security]\n");
foreach ($securitySettings as $setting => $value) {
    fwrite($fileHandle, "$setting = $value\n");
}

// Close file handle
fclose($fileHandle);

?>