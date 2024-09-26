<?php

function is_authorized_ajax_request() {
    // Check if request was made via AJAX
    $is_ajax = isset($_SERVER['HTTP_X_REQUESTED_WITH']) && $_SERVER['HTTP_X_REQUESTED_WITH'] === 'XMLHttpRequest';

    // Prevent URL inclusion attacks by checking for external domains in the REQUEST_URI server variable
    $request_uri_parts = parse_url($_SERVER['REQUEST_URI']);
    if (isset($request_uri_parts['host'])) {
        $is_local_request = strpos(strtolower($request_uri_parts['host']), strtolower(gethostname())) !== false;
        
         // Check if request is local and made via AJAX
        return $is_ajax && $is_local_request; 
    }

    die('Unauthorized access');
}

// Call the function
is_authorized_ajax_request();

?>