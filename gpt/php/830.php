
if (hash_equals($row['token'], hash('sha256', base64_decode($authenticator)))) {
    $_SESSION['userid'] = $row['userid'];
    
    // Regenerate the selector and authenticator.
    $newSelector = base64_encode(openssl_random_pseudo_bytes(9));
    $newAuthenticator = openssl_random_pseudo_bytes(33);

    // Delete the old token from the database.
    $database->exec(
