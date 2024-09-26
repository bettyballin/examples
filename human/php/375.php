public static function redirect($num, $url) {
    $host = parse_url($url, PHP_URL_HOST);
    if (!empty($host) && $host == $_SERVER['HTTP_HOST']) {
        $url = preg_replace('/[^\w\s\p{L}\d\r?,=@:\/.-]/i', '', urldecode($url));
        //header($http[$num]); //not sure what this is for?
        header("Location: " . $url);
        exit;
    } else {
        return;
    }
}