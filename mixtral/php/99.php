function get_url($request_url, $apiToken) {
    $ch = curl_init($request_url);

    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HEADER, 0);

    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Authorization: Bearer '. $apiToken
    ));

    // or

    if (strpos($request_url, "?")) {
      $request_url .= "&token=" . urlencode($apiToken);
    } else {
      $request_url .= "?token=" . urlencode($apiToken);
    }
    curl_setopt($ch, CURLOPT_URL, $request_url);

    $response = curl_exec($ch);
    curl_close($ch);

    return $response;
}