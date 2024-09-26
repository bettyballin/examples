This is not PHP code, it's Apache mod_rewrite code. However, I can provide you with a PHP alternative using a simple routing mechanism:


$uri = $_SERVER['REQUEST_URI'];
$parts = explode('/', $uri);

if ($parts[1] == 'blog') {
    $blog = implode('/', array_slice($parts, 2));
    include 'blog.php';
    $_GET['blog'] = $blog;
}