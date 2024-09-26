<?php

session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action'])) {

    switch ($_POST['action']) {
        case 'get_user_info':
            if (!isset($_SESSION['user_id']) || !isset($_SESSION['username'])) {
                $response = [
                    'success' => false,
                    'error' => 'User not logged in.'
                ];
            } else {
                $response = [
                    'success' => true,
                    'data' => [
                        'user_id' => (int) $_SESSION['user_id'],
                        'username' => $_SESSION['username']
                    ]
                ];
            }

            break;

        default:
            $response = [
                'success' => false,
                'error' => 'Invalid action.'
            ];
    }
} else {
    $response = [
        'success' => false,
        'error' => 'Invalid request method.'
    ];
}

echo json_encode($response);
exit;