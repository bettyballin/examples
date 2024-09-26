public static function redirect($num, $url)
{
    // Parse URL
    $parsedUrl = parse_url($url);

    if (isset($parsedUrl['host']) && strtolower($parsedUrl['host']) !== $_SERVER['HTTP_HOST']) {
        throw new Exception('Invalid redirection');
    }

    $http = array(
        301 => "HTTP/1.1 301 Moved Permanently",
        302 => "HTTP/1.1 302 Found",
        303 => "HTTP/1.1 303 See Other",
        307 => "HTTP/1.1 307 Temporary Redirect",
        308 => "HTTP/1.1 308 Permanent Redirect"
    );

    header($http[$num]);

    // Redirect to the URL
    header ("Location: $url");
    exit;
}