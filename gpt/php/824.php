
// Instead of using extract(), manually assign values and validate/sanitize them:
$username = isset($_POST['username']) ? filter_input(INPUT_POST, 'username', FILTER_SANITIZE_STRING) : null;
$password = isset($_POST['password']) ? filter_input(INPUT_POST, 'password', FILTER
