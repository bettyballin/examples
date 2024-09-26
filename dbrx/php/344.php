<?php

$jwt = "your_jwt_token_here"; // replace with your JSON Web Token

header('Content-Type: application/json');
header('Authorization: Bearer '.$jwt);

echo json_encode(['success' => true]);

?>