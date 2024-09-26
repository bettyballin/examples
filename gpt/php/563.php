
function isRunningOnLocalhost() {
    // List of known localhost IPs
    $whitelist = ['127.0.0.1', '::1'];

    // SERVER_ADDR is the IP address of the server where the current script is executing.
    // REMOTE_ADDR is the IP address from which the user is viewing the current page.
    if (in_array($_SERVER['SERVER_ADDR'], $whitelist) && in_array($_SERVER['REMOTE_ADDR'], $whitelist)) {
        return true;
    }

    // You may also check for a specific server file path if that's viable.
    // This can ensure the code is running in a local environment based on the
    // file structure that wouldn't be present on a production server.
    if (strpos(__FILE__, '/path/to/localhost/environment
