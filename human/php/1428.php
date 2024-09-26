<?php
try {
    $db = new PDO('sqlite:example.db');
    $sql = $db->prepare('SELECT * FROM example_table');
    if (!$sql->execute()) {
        throw new Exception($db->errorInfo()[2]);
    }
    $result = $sql->fetchAll();
    print_r($result);
} catch (Exception $e) {
    echo 'Caught exception: ',  $e->getMessage(), "\n";
}
?>