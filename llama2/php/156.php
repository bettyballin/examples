<?php
$allowed_urls = array('http://*.example1.com', 'https://*.example2.com');
$input_url = filter_var($_GET['site'], FILTER_VALIDATE_URL);

function validate_url($input_url, $allowed_urls) {
    foreach ($allowed_urls as $allowed_url) {
        $pattern = str_replace('*', '.*', $allowed_url);
        if (preg_match('/^' . $pattern . '$/', $input_url)) {
            return true;
        }
    }
    return false;
}

if (validate_url($input_url, $allowed_urls)) {
    echo 'URL is valid, proceed with your script';
} else {
    echo 'URL is not valid, reject it';
}
?>