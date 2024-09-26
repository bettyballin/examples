$salted_password_hash = hash('sha256', $userData['salt'] . hash('sha256', $password));
$hash = hash('sha256', $salted_password_hash);