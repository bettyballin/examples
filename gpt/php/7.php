
// Sanitize a string
$cleanString = filter_input(INPUT_GET, 'variable', FILTER_SANITIZE_STRING);

// Sanitize an email
$cleanEmail = filter_input(INPUT_GET, 'email', FILTER_SANITIZE_EMAIL);

// Sanitize an integer
$cleanInt = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);

// Sanitize a URL
$cleanUrl = filter_input(INPUT_GET, 'link', FILTER_SANITIZE_URL);

