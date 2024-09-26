
$ldap_host = "ldap://your-ad-domain.com"; // Your AD domain or IP
$ldap_dn = "DC=yourdomain,DC=com"; // The Distinguished Name of your AD
$ldap_user = "CN=read-only-admin,OU=Users,DC=yourdomain,DC=com"; // A user with read privileges
$ldap_password = "password";

$ldap_connection = ldap_connect($ldap_host);
if (!$ldap_connection) {
    die("Could not connect to LDAP server.");
}

ldap_set_option($ldap_connection, LDAP_OPT_PROTOCOL_VERSION, 3
