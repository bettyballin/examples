<?php

$aUrl = "http://www.example.com";
$ch = curl_init($aUrl);

curl_setopt($ch, CURLOPT_TIMEOUT, 10);
curl_setopt($ch, CURLOPT_MAXREDIRS, 2);
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, TRUE);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);

$html = curl_exec($ch);
curl_close($ch);

$maxlength = 51200; // 50 kilobytes
if ($html && strlen($html) < $maxlength) {
    $doc = new DOMDocument();
    @$doc->loadHTML($html);
    $xpath = new DOMXPath($doc);

    // Do your processing here.
    echo "HTML fetched and processed successfully!";
} else {
    die('There was an error fetching the HTML.');
}

?>