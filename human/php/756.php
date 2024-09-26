<?php
session_start();

// check if they are logged in
if (!isset($_SESSION['valid_user'])) {
    header('Location: ./login.php');
    exit; // and get out of here if they aren't
} else {
   // OK, they're logged in, let them see some content
   // functions to display the page
   display_page();
}

function display_page() {
    // your page content here
    echo "Welcome, you are logged in!";
}
?>