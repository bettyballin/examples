
function isShadyQuery($query) {
    $blacklist = ['DROP', 'OR 1=1', '--', '/*', '*/', '#', ';'];
    $query = strtoupper($query); // Make it case-insensitive

    foreach ($blacklist as $term) {
        if (strpos($query, $term) !== false) {
            return true;
        }
    }

    // Check for overly long queries
    if (strlen($query) > 80) {
        return true;
    }

    return false;
}

function handleShadyQuery($query) {
    $message = "Suspicious query detected: " . $query . "\n";
    $message .= "IP Address: " . $_SERVER["REMOTE_ADDR"] . "\n";
    $message .= "User Agent: " . $_SERVER["HTTP_USER_AGENT"] . "\n";
    // Log
