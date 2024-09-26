<?php
$dsn = 'mysql:dbname=KeyStorage;host=127.0.0.1';
$user = 'keymaster';
$password = 'zuul';
$code = 'your_code_here'; // replace with your code

try {
    $dbh = new PDO($dsn, $user, $password);
    $stmt = $dbh->prepare("SELECT stuff_tm_id FROM gozer WHERE code=:code LIMIT 1"); 
    $stmt->bindParam(':code', $code, PDO::PARAM_STR, 12);
    $stmt->execute(); 
    $row = $stmt->fetch(PDO::FETCH_ASSOC);
    if ($row) {
        $stuff = Stufff::find($row['stuff_tm_id']);
        // do something with $stuff
    } else {
        echo 'No result found';
    }
} catch (PDOException $e) {
    echo 'Where is the gatekeeper: ' . $e->getMessage();
}