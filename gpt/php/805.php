
if (php_sapi_name() == 'cli') {
    // Script is run from the command line
    if (isset($argv[1])) {
        $variableValue = $argv[1];
        // No need to check securityCode in CLI context
    }
} else {
    // Script is run through a web server
    if (isset($_GET["variableValue"]) && isset($_GET["securityCode"])) {
        $variableValue = $_GET["variableValue"];
        $securityCode = $_GET["securityCode"];
        
        // Validate the security code here
        if (validSecurityCode($
