<?php
function check_register($path) {
    // Your implementation here
    // For example:
    $registered_paths = array('/path1', '/path2');
    return in_array($path, $registered_paths);
}

$path = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH); 

if(check_register($path)){
    //load page into buffer
    ob_start();
    require($path);

    echo ob_get_clean();
}else{
    header($_SERVER['SERVER_PROTOCOL'].' 404 Not Found');
    exit;
}
?>