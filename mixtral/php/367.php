<?php
require_once 'path-to-HTMLPurifier/library/HTMLPurifier.auto.php';

$config = HTMLPurifier_Config::createDefault();

// Allow iframes embed and object
$config->set('HTML.SafeIframe', true);
$config->set('HTML.SafeObject', true);

$purifier = new HTMLPurifier($config);

$userGeneratedContent = '<p>Hello, <iframe src="https://example.com"></iframe> world!</p>';
$cleanedHtml = $purifier->purify($userGeneratedContent);

echo $cleanedHtml;
?>