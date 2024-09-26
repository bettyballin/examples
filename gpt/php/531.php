
$whitelist = array("mp3", "wav"); // Define which file extensions are allowed
$baseDir = "/path/to/your/audios/"; // Set the base directory of your audio files

// Ensure the 'file' GET parameter is set
if (!isset($_GET['file'])) {
    die("No file specified.");
}

$requestedFile = basename($_GET['file']); // Use basename to prevent directory traversal attacks

// Check the file extension
$fileExtension = strtolower(pathinfo($requestedFile, PATHINFO_EXTENSION));
if (!in_array($fileExtension, $whitelist)) {
    die("Unauthorized file type.");
}

$filePath = $baseDir . $requestedFile;

// Check if the file exists and is in the correct directory to prevent directory traversal
if (!file
