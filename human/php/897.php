It seems like you provided Java code, not PHP. Here is the equivalent PHP code:


$xml = null;

try {
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, "your_url_here");
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_POST, true);
    // add your post data here
    $response = curl_exec($ch);
    $xml = $response;
    curl_close($ch);
} catch (Exception $e) {
    echo 'Caught exception: ',  $e->getMessage(), "\n";
}