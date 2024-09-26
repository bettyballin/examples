
// Pseudo-code for the server-side check
if ($_POST['requested_access_level'] > $currentUser->getAccessLevel()) {
    // Deny the request and handle the error
}

