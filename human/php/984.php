<?php
$query = 'SELECT * FROM users';

// Check if SELECT is in the query
if (preg_match('/SELECT/', strtoupper($query)) != 0) {
    // Array with forbidden query parts
    $disAllow = array(
        'INSERT',
        'UPDATE',
        'DELETE',
        'RENAME',
        'DROP',
        'CREATE',
        'TRUNCATE',
        'ALTER',
        'COMMIT',
        'ROLLBACK',
        'MERGE',
        'CALL',
        'EXPLAIN',
        'LOCK',
        'GRANT',
        'REVOKE',
        'SAVEPOINT',
        'TRANSACTION',
        'SET',
    );

    // Convert array to pipe-seperated string
    // strings are appended and prepended with \b
    $disAllow = implode('|',
        array_map(function ($value) {
            return '\b' . $value . '\b';
        }, $disAllow));

    // Check if no other harmfull statements exist
    if (preg_match('/('.$disAllow.')/i', $query) == 0) {
        // Execute query
        $db = new PDO('mysql:host=localhost;dbname=test', 'username', 'password');
        $stmt = $db->prepare($query);
        $stmt->execute();
        $result = $stmt->fetchAll();
        print_r($result);
    } else {
        echo "Query contains forbidden keywords.";
    }
} else {
    echo "Query is not a SELECT query.";
}
?>