
// document_access.php
session_start();

if (isset($_SESSION['user_logged_in']) && $_SESSION['user_logged_in']) {
    // Retrieve the document name from the query parameter or URL
    $document = basename($_REQUEST['document']);

    // Define the path to the folder containing the documents
    $documentPath = '/path/to/your/documents/' . $document;

    if (file_exists($documentPath)) {
        // Set appropriate headers for download
        header('Content-Type: application/octet-stream');
        header('Content-Disposition: attachment; filename="' . basename($document) .
