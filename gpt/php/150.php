
// This is your secret key, keep it safe!
$secretKey = 'your_super_secret_key';

// This is the id of the classified
$id = $_GET['id'];

// Current timestamp
$timestamp = time();

// Create a hash
$hash = hash_hmac('sha256', $id . $timestamp, $secretKey);

// Generate the URL
$url = "www.domain.com/partner.php?id={$id}&timestamp={$timestamp}&hash={$hash}";

