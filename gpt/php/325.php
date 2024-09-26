
if (isset($_SERVER['HTTP_REFERER']) && parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST) === $_SERVER['HTTP_HOST']) {
    include('bootstrap.js');
} else {
    echo "document.write('Access Denied');";
}

