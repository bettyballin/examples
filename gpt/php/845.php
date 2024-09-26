
session_start();

// Check if the user is logged in
if (!isset($_SESSION['userId'])) {
    die('Access denied: User not logged in.');
}

// Define the upload directory and file name
$uploadDir = 'uploads/';
$fileName = $_SESSION['userId'].".pdf";
$filePath = $uploadDir.$fileName;

// Check if the file exists and belongs to the user
if (file_exists($filePath)) {
    // Set headers to download the file
    header('Content-Description:
