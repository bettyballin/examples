<?php

// Start the session
session_start();

// check session variables for user roles and set page mode accordingly.
if(isset($_GET['mode']) && ($_GET['mode'] == 'Insert' || $_GET['mode'] == 'Edit')) {
    if(($_GET['mode'] == 'Insert' && isset($_SESSION['insertMode'])) ||
       ($_GET['mode'] == 'Edit'   && isset($_SESSION['editMode']))) {

        // set page mode
        $page_mode = $_GET['mode'];
        
    } else {
        echo "You don't have permission to access this resource.";
        exit;
    }
} else if(isset($_GET['mode']) && ($_GET['mode'] == 'View')) {
    // view mode doesn't require any user role check
    $page_mode = $_GET['mode'];
}

// rest of your code

?>