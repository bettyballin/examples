<?php

$header = "GET / HTTP/1.1\r\n";
$header .= "Host: example.com\r\n";
$header .= "Accept: */*\r\n\r\n";

$fp = fsockopen('example.com', 80, $errno, $errstr, 30);
if (!$fp) {
    echo "$errstr ($errno)\n";
} else {
    fwrite($fp, $header);
    $response = '';
    while (!feof($fp)) {
        $response .= fgets($fp, 128);
    }
    fclose($fp);
    echo $response;
}

?>