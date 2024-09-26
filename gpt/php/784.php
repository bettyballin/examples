
function isValidUrl($url) {
    $sanitizedUrl = filter_var($url, FILTER_SANITIZE_URL);
    $validatedUrl = filter_var($sanitizedUrl, FILTER_VALIDATE_URL);
    if ($validatedUrl === false) {
        return false; // Not a valid URL
    }

    $scheme = parse_url($validatedUrl, PHP_URL_SCHEME
