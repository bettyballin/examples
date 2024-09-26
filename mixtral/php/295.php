<?php

function validateUrl() {
    $url = $_SERVER['REQUEST_URI'];

    // Get device ID and signature from request
    $deviceId = isset($_GET["deviceId"]) ? intval($_GET["deviceId"]) : null;
    $signature = isset($_GET["signature"]) ? $_GET["signature"] : null;

    if ($deviceId === null || $signature === null) {
        echo json_encode(array('status' => "not valid"));
        die();
    }

    // Fetch device details from the database
    $db = new PDO("mysql:host=localhost;dbname=myDatabase", 'username', 'password');

    try {
        $stmt = $db->prepare('SELECT id, random FROM devices WHERE enabled = 1 AND id = :deviceId LIMIT 1');

        // Bind parameters
        $stmt->bindParam(":deviceId", $deviceId);

        if ($stmt->execute()) {
            while($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
                extract($row);

                // Generate the expected signature
                $expectedSignature = hash('sha3-256', "{$id}{$random}");

                if ($signature === $expectedSignature) {
                    echo json_encode(array("status" => 'valid'));
                } else {
                    // Signature mismatch
                    http_response_code(401);
                    echo json_encode(array("status" => 'invalid signature'));
                }
            }
        } else {
            echo json_encode(array("status" => 'database error'));
        }
    } catch (PDOException $e) {
        echo json_encode(array("status" => 'database error'));
    }
}

validateUrl();

?>