<?php
class Signature{

    public $msg;

    public function hash()
    {
        $key = "hello";
        $msg = "Hello";
        $hash = hash_hmac('sha256', $msg, $key, true);
        error_log('---hash ===>' . bin2hex($hash));

        return $hash;
    }

    public function hmacHex()
    {
        $hash = hash_hmac('sha256', $this->msg, "hello", false);

        error_log('---hmacHex ===>' . bin2hex($hash));

        return $hash;
    }
}

$obj = new Signature();

// Store the raw binary output from hash()
$res = $obj->hash();

// Pass it to hmacHex
$obj->msg = $res;

echo bin2hex($obj->hmacHex());
?>