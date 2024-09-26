
$name = $con->real_escape_string($_POST['name']);
$username = $con->real_escape_string($_POST['username']);
$email = $con->real_escape_string($_POST['email']);
$password1 = $con->real_escape_string($_POST['pass1']);
$password2 = $con->real_escape_string($_POST['pass2']);

// Start with the assumption that the input is valid
$isValid = true;

// Check for empty fields
if (empty($name) || empty($username) || empty($email) || empty($password1) || empty($password2)) {
    echo "Complete all fields";
    $isValid = false;
}

// Validate email
if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    echo "Enter a valid email";
    $isValid = false;
}

// Check password length
if
