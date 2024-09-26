
function hash_password($password, $salt, $site_key) {
    $hash = hash('sha512', $password . $salt . $site_key);
    for ($i = 0; $i < 1000; $i++) {
        $hash = hash('sha512', $hash . $salt . $site_key);
    }
    return $hash;
}

