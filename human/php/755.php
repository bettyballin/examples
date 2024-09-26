<?php
session_start();

// check if they are logged in
if (!isset($_SESSION['valid_user'])) {
    header('Location: ./login.php');
    // and get out of here if they aren't
    exit();
}
// OK, they're logged in, let them see some content
// functions to display the page
function display_page() {
    echo "Welcome, you are logged in!";
}

display_page();
?>