<?php

// Configuration
$trustedDir = '/path/to/trusted/directory';
$allowedTlds = array('com', 'net', 'org'); // Add more TLDs as needed

// Input validation and sanitization
if (isset($_POST['domain'])) {
    $domain = filter_var($_POST['domain'], FILTER_SANITIZE_STRING);
} else {
    // Handle missing input
    http_response_code(400);
    echo 'Missing domain parameter';
    exit;
}

// TLD validation
$tld = substr(strrchr($domain, '.'), 1);
if (!in_array($tld, $allowedTlds)) {
    // Handle invalid TLD
    http_response_code(400);
    echo 'Invalid TLD';
    exit;
}

// Prepare script execution
$today = date("Y-m-d-H:i:s");
$scriptPath = $trustedDir . '/script.sh';

// Set environment variable for the domain
putenv('DOMAIN=' . $domain);

// Execute the script with the validated domain
try {
    $output = array();
    $returnValue = null;
    exec($scriptPath, $output, $returnValue);
    if ($returnValue !== 0) {
        // Handle script execution error
        http_response_code(500);
        echo 'Script execution failed with code ' . $returnValue;
    } else {
        // Handle successful execution
        http_response_code(200);
        echo 'Script executed successfully';
    }
} catch (Exception $e) {
    // Handle execution exception
    http_response_code(500);
    echo 'Execution exception: ' . $e->getMessage();
}

?>