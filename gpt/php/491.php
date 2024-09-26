
<?php
// Initialize error message as empty
$errorMessage = '';

// Your login logic here
if (isset($_POST['name']) && isset($_POST['pass'])) {
    // Assuming $username and $password are your stored credentials
    if ($_POST['name'] !== $username) {
        $errorMessage = "Sorry, that username does not match.";
    } else if ($_POST['pass'] !== $password) {
        $errorMessage = "Sorry, that password does not match.";
    } else {
        // Set cookie and redirect as needed
        setcookie('MyLoginPage', md5($_POST['pass'].$randomword));
        header("Location: $_SERVER[PHP_SELF]");
        exit;
    }
}
?>

<!-- Your HTML login form -->
<div>
    <!-- Check if there's an error message and display it
