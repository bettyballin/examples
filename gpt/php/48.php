
$whitelist = ['about', 'contact', 'home']; // List of allowed pages
$page = $_GET['page'] ?? 'default_page'; // Default to a safe page

if (in_array($page, $whitelist)) {
    include $_SERVER['DOCUMENT_ROOT'] . '/
