
// Assuming $pdo is your PDO connection object and $facebook is your Facebook SDK object
$me = $facebook->api('/me');
$name = $me['name'];
$id = $me['id'];

// Prepared statement
