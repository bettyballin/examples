<?php
session_start();

if (empty($_SESSION['userid']) && !empty($_COOKIE['remember'])) {
    list($selector, $authenticator) = explode(':', $_COOKIE['remember']);

    // Fetch token from database using selector
    $database = new PDO('your_database_connection_string');
    $row = $database->prepare("SELECT * FROM auth_tokens WHERE selector = ?");
    $row->execute([$selector]);
    $row = $row->fetch();

    if (hash_equals($row['token'], hash('sha256', base64_decode($authenticator)))) {
        $_SESSION['userid'] = $row['userid'];

        // Regenerate login token and update database & cookie
        regenerateLoginToken($database);
    }
}

function regenerateLoginToken($database) {
    $selector = base64_encode(openssl_random_pseudo_bytes(9));
    $authenticator = openssl_random_pseudo_bytes(33);

    setcookie(
        'remember',
        $selector . ':' . base64_encode($authenticator),
        time() + 864000,
        '/',
        'yourdomain.com',
        true, // TLS-Only
        true   // Http-only
    );

    $database->prepare("UPDATE auth_tokens SET selector = ?, token = ? WHERE userid = ?")
        ->execute([
            $selector,
            hash('sha256', $authenticator),
            $_SESSION['userid']
        ]);
}