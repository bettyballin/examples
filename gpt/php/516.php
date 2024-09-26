
session_start();

// Check if the user is logged in and authorized
if (isset($_SESSION['user_id']) && userHasAccessToTheFile($_SESSION['user_id'])) {
    // Set the appropriate headers for the file
    header('Content-Type: application/pdf');
    header('Content-Disposition: attachment; filename="downloaded.pdf"');
    
    // Specify the file path outside the web root
    $filePath = '/path/to/your/private/files/the-file.pdf';
    
    // Clear any output buffers
    ob_clean();
    flush();
    
    // Read and output the file directly
    readfile($filePath);
    exit;
} else {
    // Handle the case where the user is not authorized to access the file
