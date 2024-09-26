
$root = '/var/www/myapp/files/';
$userInput = $_GET['path'];

// Remove any NULL bytes
$userInput = str_replace(chr(0), '', $userInput);

// Securely combine user input with the root path
$path = $
