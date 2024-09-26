<?php

$server = 'your_ad_domain';
$username = 'your_username';

// Connecting to LDAP
if ($connect = ldap_connect($server)) {
    // Binding anonymously
    if (ldap_bind($connect)) {
        echo "Connected successfully";

        $search = 'CN=Users,DC=yourdomain,DC=com';

        /* Searching for user */

        // Set search filter

        $filter = "(sAMAccountName=$username)";

        if ($result = ldap_search($connect, $search, $filter)) {
            echo "Search successful...";

            $entries = ldap_get_entries($connect, $result);

            for ($i = 0; $i < $entries["count"]; $i++) {
                echo "User found: " . $entries[$i]["cn"][0] . "\n";
            }
        } else {
            echo "Search failed.";
        }
    } else {
        die('Could not bind');
    }
} else {
    die('Could not connect');
}
?>