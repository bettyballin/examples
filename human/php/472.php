<?php

$data = [
    ['id' => 1, 'name' => 'John', 'password' => 'dsfa9p8y098hasdf'],
    ['id' => 2, 'name' => 'Paul', 'password' => 'po43pokdfgpo3k4y'],
    ['id' => 3, 'name' => 'John', 'password' => 'dsfa9p8y098hasdf'],
];

$users = [];
foreach ($data as $user) {
    $users[$user['id']] = [
        'id' => $user['id'],
        'name' => $user['name'],
        'password' => password_hash($user['password'], PASSWORD_DEFAULT),
    ];
}

print_r($users);



<?php

$data = [
    ['id' => 1, 'name' => 'John', 'password' => 'dsfa9p8y098hasdf'],
    ['id' => 2, 'name' => 'Paul', 'password' => 'po43pokdfgpo3k4y'],
    ['id' => 3, 'name' => 'John', 'password' => 'dsfa9p8y098hasdf'],
];

$users = [];
foreach ($data as $user) {
    $users[$user['id']] = [
        'id' => $user['id'],
        'name' => $user['name'],
        'password' => hash('sha256', $user['password']),
    ];
}

print_r($users);