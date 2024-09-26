<?php
$signature = new Signature();
$msg = 'your_message_here';
$hashHex = $signature->getHash('sha256', $msg, true)->hexEncode();
error_log('---SecureAI hash (hex) ===>' . $hashHex);
class Signature {
    function getHash($algo, $data, $raw) {
        $hash = hash($algo, $data, $raw);
        return new Hash($hash);
    }
}
class Hash {
    private $hash;
    function __construct($hash) {
        $this->hash = $hash;
    }
    function hexEncode() {
        return bin2hex($this->hash);
    }
}
?>