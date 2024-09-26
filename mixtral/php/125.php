$allowed_pages = ['home', 'about'];

if(isset($_GET['page']) && in_array($_GET['page'], $allowed_pages)) {
    $file = $_GET['page'];
    include($file . '.php');
} else {
    die('Invalid page');
}