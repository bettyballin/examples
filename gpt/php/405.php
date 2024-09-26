
<?php

$site = $_GET['site'];

// Define an array of allowed sites
$allowed_sites = ['site1', 'site2', 'site3'];

// Sanitize and validate the site variable
$site = preg_replace('/[^a-zA-Z0-9_\-]/', '', $site);

if (in_array($site, $allowed_sites)) {
    $config_path = "configs/{$site}/config.php";
    
    // Check if the
