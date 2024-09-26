
if (!filter_var($site, FILTER_VALIDATE_URL) || !in_array(parse_url($site, PHP_URL_SCHEME), ['http', 'https'])) {
    // Handle the error - not a valid URL
    exit('Invalid URL');
}

