<?php

$is_valid_user = false;

try {
    $ds = ldap_connect('ldap://ldap.foo.com', 636); // Use LDAPS

    if (!ldap_set_option($ds, LDAP_OPT_REFERRALS, 0) || !ldap_start_tls($ds)) {
        throw new Exception("Failed to set options or start TLS.");
    }

    ldap_set_option($ds, LDAP_OPT_PROTOCOL_VERSION, 3);

    $user = 'your_username';
    $passwd = 'your_password';

    $bind = @ldap_bind(
        $ds,
        'uid='.$user.',ou=people,dc=ldap,dc=foo,dc=com',
        $passwd
    );

    if (!$bind) {
        throw new Exception("Invalid credentials.");
    }

    $is_valid_user = true;

    // ... rest of your code
} catch (Exception $e) {
    echo 'Caught exception: '.$e->getMessage()."\n";

    return false;
}