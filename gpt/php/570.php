
<?php
// Check if the server received a POST request
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Get the raw POST data
    $jsonContent = file_get_contents('php://input');

    // Decode the JSON content
    $report = json_decode($jsonContent, true);

    // Write the report to a file for demonstration purposes
    // In a production environment, you would likely want to store this in a database or logging system
    file_put_contents('csp-report.txt', print_r($report, true), FILE_APPEND);

    // Respond with a 204 No Content status code to acknowledge receipt
    http_response_code(204);
} else {
    // Incorrect method (not
