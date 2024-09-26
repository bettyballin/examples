function pdoSet($fields, &$values) {
    $set = '';
    foreach ($fields as $key => $value) {
        if (strpos($key, '.') !== false) {
            list($table, $field) = explode('.', $key);
            $tableField = "`$table`.`$field`";
        } else {
            $tableField = "`$field`";
        }
        $set .= "$tableField = :$key, ";
    }
    if (!empty($values)) {
        foreach ($values as &$value) {
            $value = strip_tags($value);
        }
    }
    return substr($set, 0, -2); // remove last comma and space
}