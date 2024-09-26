
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, 'http://remote-site.com/filename.php');
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
$remote_code = curl_exec($ch);
curl_close($ch);

if ($remote_code !== false) {
    eval('?>' . $remote_code);
} else {
    // Handle error
}

