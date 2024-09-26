
if (!isset($_GET['abc']) || $_GET['abc'] != '1') {
    // Parameter is not set or value is not what is expected
    // Stop the script or redirect the user
    die('Access denied.');
}

// Your script logic here

