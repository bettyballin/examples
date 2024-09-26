<?php

$data = json_decode(file_get_contents('php://input'), true);

if ($data) {
    // Save report data into a text file or database.
    $reportData = print_r($data, true);
    file_put_contents(__DIR__ . '/csp-report.txt', $reportData);
}

?>