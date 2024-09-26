function safeXSS($input) {
    return htmlspecialchars(strip_tags($input), ENT_QUOTES | ENT_SUBSTITUTE);
}

if (isset($_POST['search'])) {
    $search = array_map('safeXSS', $_POST);
} else if (!empty($_GET)) {
    // Decode and sanitize URI parameters
    $query = $_SERVER['QUERY_STRING'];
    parse_str(rawurldecode($query), $getParams);

    foreach ($getParams as &$param) {
        $param = safeXSS($param);
    }

    $search = array_map('safeXSS', $_GET);
}