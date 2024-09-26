
// Get values from the POST super global variables
$raw_password = $_POST['password'];
$conf_raw_password = $_POST['conf_password'];

// Call the function to check if the passwords match
passwords_match_check($raw_password, $conf_raw_password);

// If they match, proceed to hash the password
if (empty($errors)) {
    $hashed_password = password_encrypt($raw_password);
    // Store $hashed_password in your database
}

// Defined function to check if the plain passwords match
function passwords_match_check($raw_pw, $conf_raw_pw) {
    global $errors
