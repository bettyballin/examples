<?php
function getTitle($aUrl) {
    $allowedHosts = array('localhost', '127.0.0.1', '::1'); 
    $regex = '/^(?!(' . implode('|', $allowedHosts) . ')$)/';

    if (!preg_match($regex, $aUrl)) {
        return FALSE;
    }

    $doc = new DOMDocument();
    @$doc->loadHTMLFile($aUrl);
    $xpath = new DOMXPath($doc);

    if (!isset($xpath->query('//title')->item(0)->nodeValue)) {
        return FALSE;
    }

    return $xpath->query('//title')->item(0)->nodeValue;
}

// Example usage:
$url = "http://example.com";
$title = getTitle($url);
if ($title !== FALSE) {
    echo $title;
} else {
    echo "Failed to retrieve title";
}
?>