
$allowedPages = array(
    'home' => 'home.php',
    'contact' => 'contact.php',
    // Add other allowed pages and their corresponding file names here
);

$page = $_GET['page'] ?? 'defaultPage';

// Check if the provided page is in
