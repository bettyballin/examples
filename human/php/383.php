function callWebService($url, $username, $hash) {
  $data = array('username' => $username, 'hash' => $hash);
  $options = array(
    'http' => array(
      'method'  => 'POST',
      'content' => http_build_query($data)
    )
  );
  $context  = stream_context_create($options);
  $result = file_get_contents($url, false, $context);
  return $result;
}

$url = 'http://example.com/webservice'; // replace with your web service URL
$username = 'your_username'; // replace with your username
$hash = 'your_hash'; // replace with your hash

$response = callWebService($url, $username, $hash);
echo $response;