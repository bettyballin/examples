
$_file = $_GET['filename'];
$sPattern = '/\s*/m';
$sReplace = '';

$_strippedfile = preg_replace($sPattern, $sReplace, $_file);

// Determine MIME type by file extension (you may want to do this more robustly)
$mime = 'application/vnd.ms-excel'; // Default MIME type for older Excel files
if (strtolower(substr($_strippedfile, -5)) === '.xlsx') {
    $mime = '
