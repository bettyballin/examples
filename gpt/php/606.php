
// check if they are logged in
if (!isset($_SESSION['valid_user'])) {
    header('Location: ./login.php');
    exit(); // Terminate script execution if not logged in
}

// functions to display the page
display_page();

