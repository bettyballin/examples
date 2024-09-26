
session_start();
$components = explode('/', $url, 3);

$isAjaxRequest = !empty($_SERVER['HTTP_X_REQUESTED_WITH']) && strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) == 'xmlhttprequest';

if (!isset($_SESSION['loggedin']) && $components[0] != 'access' && $components[0] != 'login') {
    if ($isAjaxRequest) {
        // Respond with JSON for AJAX requests
        header('Content-Type: application/json');
        echo json_encode(array('error' => 2000, 'msg' => 'You must be logged in to do that.'));
        exit;
    } else {
        // Redirect to login page for direct URL access
        header('Location: /login.php');
        exit;
    }
}

