$user = [
    'salts' => 'a:b:c',
];

$characters = ['x', 'y', 'z'];

$partial_password = str_repeat('*', count($characters));

foreach ($characters as $index => $character) {
    $salts = explode(':', $user['salts']);
    if (isset($salts[$index])) {
        $partial_password[$index] = $character;
    }
}

echo $partial_password;