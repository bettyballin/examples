
$options = ['cost' => 12]; // The cost parameter can be changed to increase or decrease the computational effort required to create the hash.
$hash = password_hash($password, PASSWORD_BCRYPT, $options);

