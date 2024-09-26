$controller = '\\Namespace\\' . ucfirst(strtolower($endpoint[0])) . 'Controller';
if (class_exists($controller)) {
    $instance = new $controller();

    if (!method_exists($instance, $endpoint[1]) || !is_callable([$instance, $endpoint[1]])) {
        echo json_encode($StatusCodes["no_function"]);
        die();
    }

    try {
        // Call the function and return the result
        $result = $instance->{$endpoint[1]}();
        echo json_encode($result);
    } catch (Exception $e) {
        echo json_encode($StatusCodes["internal_server_error"]);
        die();
    }
} else {
    echo json_encode($StatusCodes["no_controller"]);
    die();
}