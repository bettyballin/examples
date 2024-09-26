public static function redirect($num, $url)
{
    // Replace 'example.com' with your actual domain name
    $domain = "http://example.com";
    
    // Check if the url is inside our domain or not
    if (strpos($url, $domain) !== 0) {
        throw new Exception("Invalid redirect URL");
    }
    
    $http = array(
        301 => "HTTP/1.1 301 Moved Permanently",
        302 => "HTTP/1.1 302 Found",
        303 => "HTTP/1.1 303 See Other",
        307 => "HTTP/1.1 307 Temporary Redirect",
        308 => "HTTP/1.1 308 Permanent Redirect"
    );
    
    header($http[$num]);
    header("Location: {$url}");
    exit;
}