
// Assuming $_GET['user_input'] could be a user-provided string
$safe_output = htmlspecialchars($_GET['user_input'], ENT_QUOTES, 'UTF-8');

