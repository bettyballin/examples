
// Define your whitelist of allowed pages
$existingPages = ["index", "profile", "login", "register"];

// Get the page parameter from the URL
$page = preg_replace('/[^A-Za-z]/', '', filter_input(INPUT_GET, 'page'));

// Check if the requested page is in the whitelist
if (in_array($page, $existingPages)) {
    // The requested page is in the whitelist
    $file = $this->moduleDir . $page . ".php";
    if (file_exists($file)) {
        require_once $file;
        $class = new $page($this);
        // Continue with processing
    } else {
        // File does not exist, handle the error (e.g., show a 404 page)
        header($_SERVER["SERVER_PROTOCOL"] . " 404 Not Found", true, 404);
        $this->loadPage("404");
    }
} else {
    // The requested page is not in the whitelist, handle
