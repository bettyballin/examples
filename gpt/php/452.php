
require_once('tcpdf_include.php');

// Create new PDF document
$pdf = new TCPDF(PDF_PAGE_ORIENTATION, PDF_UNIT, PDF_PAGE_FORMAT, true, 'UTF-8', false);

// Set the document information
$pdf->SetCreator(PDF_CREATOR);
$pdf->SetAuthor('Author Name');
$pdf->SetTitle('Title');
$pdf->SetSubject('Subject');
$pdf->SetKeywords('TCPDF, PDF, example, test, guide');

// Set the password for the PDF
$pdf->SetProtection($permissions = array('print', 'copy'), $user_pass = 'user_password', $owner_pass = null, $mode = 0, $pubkeys = null);

// Add a page
$pdf->AddPage();

// Set some content to print
$html = <<<EOD
