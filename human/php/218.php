<?php

// RESTful service
$action = 'action_' . filter_input(INPUT_GET, 'action', FILTER_SANITIZE_STRING);
$params = filter_input(INPUT_GET, 'params', FILTER_SANITIZE_STRING);

if (function_exists($action))
{
    // Run the action w/ the parameters
    $data = call_user_func_array($action, json_decode($params, true));

    // Encode the data in a HTTP friendly way...
    $output = json_encode($data);

    header('Content-Type: application/json');
    echo $output;
}
else
{
    header('HTTP/1.1 404 Not Found');
    header('Content-Type: application/json');
    echo json_encode(['error' => 'Invalid action: ' . htmlspecialchars($action)]);
    exit;
}

function action_foo($param1)
{
    return ["Param 1" => $param1];
}

?>