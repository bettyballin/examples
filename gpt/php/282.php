
    $columnMap = [
        '1' => 'username',
        '2' => 'email',
        // ...
    ];

    $column = $columnMap[$_GET['sort']] ?? null;
    
