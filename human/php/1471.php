<?php

class Signature {

    public function hash()
    {
        $key = "hello";
        $msg = "Hello";
        $hash = hash_hmac('sha256', $msg, $key, true);
        error_log('---hash ===>'.$hash);
        return $hash;
    }

    public function hmacHex($msg)
    {
        $key = "hello";
        $hash = hash_hmac('sha256', $msg, $key, false);
        error_log('---hmacHex ===>' . $hash);
        return $hash;
    }
}

$obj = new Signature();

$res = $obj->hash();
$obj->hmacHex($res);

?>