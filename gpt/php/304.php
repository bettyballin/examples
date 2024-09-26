
<?php

// Assuming the file is uploaded and stored temporarily on the server
$uploadedFile = $_FILES['uploadedfile']['tmp_name'];
$safePath = escapeshellarg($uploadedFile);

// Scan the file using ClamAV's clamscan command-line utility
$command = 'clamscan ' . $safePath;
$output = shell_exec($command);

// Interpret the output
if (preg_match('/.*: OK/', $output)) {
    echo "The file is safe.";
    // Proceed with further file handling
} elseif (preg_match('/.*: (.*) FOUND/', $output)) {
    echo "A virus was found and the file is not safe.";
    // Handle the infected file, e.g., delete it, log the event, etc.
} else {
    echo "An error occurred during the virus scan.";
   
