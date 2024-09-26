
<?php

function linkify($text) {
    $urlPattern = '/\b(?:https?:\/\/|www\.|twitter\.com\/#!\/|mailto:)\S+[^\s.,!?(){}<>"]+/i'; // This is a simple regex pattern, you might need a more complex one depending on your needs.
    
    return preg_replace_callback($urlPattern, function ($matches) {
        // The entire matched URL is captured in $matches[0]
        $url = $matches[0];
        
        // Sanitize the URL to prevent XSS attacks
        $safeUrl = filter_var($url, FILTER_SANITIZE_URL);
        
        // Validate the URL
        if
