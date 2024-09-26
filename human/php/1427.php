try {
    if (!$db->exec($sql)) {
        throw new Exception($db->lastErrorMsg());
    }
} catch (Exception $e) {
    echo 'Caught exception: ',  $e->getMessage(), "\n";
}