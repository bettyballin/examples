
$secret_key = 'your_secret_key';
$score = $_POST['score'];
$token = $_SESSION['token'];
$signature = hash_hmac('sha256', $score . $token, $secret_key);

