
$allowed_pages = array('home', 'contact', 'about');
$page = isset($_GET['page']) ? $_GET['page'] : 'default_page';

if (in_array($page, $allowed_pages)) {
    require $page . '.php';
} else {
    // Redirect to a default page or an error page
    echo redirect_tempo(500, 'index.php?page=404');
}

