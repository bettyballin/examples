<?php
function validateUser($user, $passwd) {
    $is_valid_user = false;

    $ds = ldap_connect('ldap.foo.com', 389);
    ldap_set_option($ds, LDAP_OPT_REFERRALS, 0);
    ldap_set_option($ds, LDAP_OPT_PROTOCOL_VERSION, 3);

    if (!@ldap_start_tls($ds)) {
        return "";
    }

    $bindUser = 'uid='.ldap_escape($user, null, LDAP_ESCAPE_DN).',ou=people,dc=ldap,dc=foo,dc=com';
    if (@ldap_bind($ds, $bindUser , $passwd)) {
        $is_valid_user = true;

        $srch = ldap_search($ds, $bindUser, '(objectClass=*)', ['cn']);
        $info = ldap_get_entries($ds, $srch);
        $userdn = $info[0]["dn"];
        $usernm = $info[0]["cn"][0];

        return $usernm;
    } else {
        return "";
    }
}

// Example usage
$user = 'your_username';
$passwd = 'your_password';
echo validateUser($user, $passwd);
?>