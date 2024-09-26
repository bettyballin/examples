
    $allowedColumns = ['username', 'email', 'created_at'];
    $sortColumn = $_GET['sort'];
    if (in_array($sortColumn, $allowedColumns)) {
        // It's safe to use
