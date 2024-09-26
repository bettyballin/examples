
function isPubliclyAccessible($url) {
    $parts = parse_url($url);

    // Check the scheme is http or https
    if (!in_array($parts['scheme'], ['http', 'https'])) {
        return false;
    }

    // Use filter_var to validate the IP address, if it's an IP
    if (isset($parts['host']) && filter_var($parts['host'], FILTER_VALIDATE_IP)) {
        $ip = $parts['host'];

        // Check if the IP is a private or reserved IP
        if (!filter_var($ip, FILTER_VALIDATE_IP, FILTER_FLAG_NO_PRIV_RANGE | FILTER_FLAG_NO_RES_RANGE)) {
            return false;
        }
    } else {
        // If it's not an IP, it could be a local
