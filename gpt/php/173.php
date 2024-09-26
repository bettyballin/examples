
function loginUser($username, $password) {
    global $DBH;

    // Retrieve the user's stored hash and salt from the database
    $q = $DBH->prepare("SELECT id, password, salt FROM users WHERE username = ?");
    $username = filter_var($username, FILTER_SANITIZE_STRING);
    $q->execute(array($username
