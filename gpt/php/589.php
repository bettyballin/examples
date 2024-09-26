
if (!empty($_SERVER['HTTP_X_REQUESTED_WITH']) && strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) === 'xmlhttprequest') {
    // This is an Ajax request
    // Do something
} else {
    // This is not an Ajax request
    // Handle accordingly, possibly exit or throw an error
    exit('Access denied');
}

