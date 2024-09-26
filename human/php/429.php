<?php
$input = '1_abcd_1';

// Set the desired format
$filter_options = array(
    'options' => array(
        // choose a regular expression that matches your format
        'regexp' => '/^[\d]_[a-z]{4}_[\d]$/'
    )
);

$format = filter_var($input, FILTER_VALIDATE_REGEXP, $filter_options);
if ($format !== false) {
    // process input
    $someString = substr($format, strripos($format, "_") + 1);
    $i = (int) $someString;
    echo '$i = ', $i;
} else {
    // Handle invalid format
    echo 'Malformed data. Potentially malicious';
}
?>