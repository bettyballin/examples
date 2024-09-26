
function isRequestFromSameServer() {
    // Get the server's IP
    $serverIP = $_SERVER['SERVER_ADDR'];

    // Get the IP address of the request's origin
    $remoteIP = $_SERVER['REMOTE_ADDR'];

    // Compare both IPs
    return $serverIP === $remoteIP;
}

if (isRequestFromSameServer()) {
    echo "The request originated from the hosting server.";
} else {
    echo "The request originated from a different source.";
}

