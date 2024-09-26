
if (!isset($_SERVER["HTTPS"]) || $_SERVER["HTTPS"] != "on") {
    if ($_SERVER['SERVER_PORT'] != 443) {
        $redirectUrl = "https://" . $_SERVER["SERVER_NAME"] . $_SERVER["REQUEST_URI"];
        header("HTTP/1.1 301 Moved Permanently");
        header("Location: $redirectUrl");
        exit();
    }
}

