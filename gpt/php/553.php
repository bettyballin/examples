
$options = [
    'cost' => 10, // the cost parameter can range from 4 to 31
];

$hashedPassword = password_hash($password, PASSWORD_BCRYPT, $options);

