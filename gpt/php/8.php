
// Validate an integer
$validInt = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT);

// Validate an email
$validEmail = filter_input(INPUT_GET, 'email', FILTER_VALIDATE_EMAIL);

// Validate a URL
$validUrl = filter_input(INPUT_GET, 'link', FILTER_VALIDATE_URL);

// Check if the variable is set and not false
if (
