
if(isset($_GET['file']) && isset($_SESSION['user']['account_id'])) {
    // Sanitize the filename
    $filename = basename($_GET['file']);

    // Construct the file path
