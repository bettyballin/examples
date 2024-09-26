
if ($loginSuccessful) {
    // Instead of readfile('dashboard.php');
    include('dashboard.php');
} else {
    // Redirect to the login page
    header('Location: login.php');
    exit();
}

