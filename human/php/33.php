<?php
$curl = curl_init('http://www.example.com');

//don't fetch the actual page, you only want to check the connection is ok
curl_setopt($curl, CURLOPT_NOBODY, true);

//stop it from outputting stuff to stdout
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);

//proxy settings
curl_setopt($curl, CURLOPT_PROXYPORT, 8080);
curl_setopt($curl, CURLOPT_PROXY, 'proxyhost');
curl_setopt($curl, CURLOPT_PROXYUSERPWD, 'user:password');

$result = curl_exec($curl);

if ($result === false) {
    die(curl_error($curl)); 
}
curl_close($curl);
?>