<?php
use SecureAILibrary\Signature;

$key = "hello";
$msg = "Hello";

$signature = new Signature($key);
$hash = $signature->getHash('sha256', $msg, true);
error_log('---SecureAI hash ===>' . $hash);
?>