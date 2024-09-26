
$accessToken = '...'; // Retrieve this from where you have stored it
$url = "https://graph.facebook.com/me?access_token={$accessToken}";

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
$result
