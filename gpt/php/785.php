
function maskSensitiveData($errno, $errstr, $errfile, $errline, array $errcontext) {
    // Check if the error context or message contains sensitive data
    if (isset($errcontext['password'])) {
        $errcontext['password'] = '********'; // Mask the password
    }

    if (isset($errcontext['username'])) {
        $errcontext['username'] = '********'; // Mask the username
   
