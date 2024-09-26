<?php

$domainPattern = '/^(www\\.)?(example\\.com|sub\\.example\\.com)$/';
$currentDomain  = $_SERVER['HTTP_HOST'];

if (!preg_match($domainPattern, $currentDomain)) {
    // Handle unauthorized access or redirect to a safe page.
    http_response_code(401);
    echo "Unauthorized access";
    exit;
}

?>