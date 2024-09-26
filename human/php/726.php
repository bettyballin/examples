<?php
// Not executable as is, since this is Objective-C code for iOS development.
// However, I can provide you a similar example using PHP:

$url = 'path_to_your_pdf_file.pdf';
$filename = basename($url);

header('Content-Type: application/pdf');
header('Content-Disposition: inline; filename="' . $filename . '"');
header('Content-Transfer-Encoding: binary');
header('Accept-Ranges: bytes');

readfile($url);
?>