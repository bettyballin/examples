<?php

function genkey($serial,$seed,$date,$type) {
    $fullstring = $serial.$seed.$date.$type;
    $md5 = md5($fullstring);
    $encrypted = encrypt_decrypt('encrypt',$md5);
    return condense(condense($encrypted));
}

function encrypt_decrypt($action, $string) 
{
    $output = false;
    $encrypt_method = "AES-256-CBC";
    $secret_key = '[REDACTED]'; //32 byte
    $secret_iv = '[REDACTED]'; //16 byte
    // hash
    $key = hash('sha256', $secret_key);    
    // iv - encrypt method AES-256-CBC expects 16 bytes 
    $iv = substr(hash('sha256', $secret_iv), 0, 16);
    if ( $action == 'encrypt' ) {
        $output = openssl_encrypt($string, $encrypt_method, $key, 0, $iv);
        $output = base64_encode($output);
    } else if( $action == 'decrypt' ) {
        $output = openssl_decrypt(base64_decode($string), $encrypt_method, $key, 0, $iv);
    }
    return $output;
}

function condense($str) {
    $arr = str_split($str, 3);
    $retstr = '';
    for($i=0;$i<count($arr);$i++) {
        $sum=WordSum($arr[$i]);
        $letternum = $sum%26 + 65; //ascii code for capital letter
        $letter = chr($letternum);
        $retstr .= $letter;
    }
    return $retstr;
}

function WordSum($word) {
    $sum = 0;
    for($i=0;$i<strlen($word);$i++) {
        $sum += ord($word[$i]);
    }
    return $sum;
}

// Test the functions
$serial = '12345';
$seed = '67890';
$date = '2022-01-01';
$type = 'test';

$key = genkey($serial, $seed, $date, $type);
echo "Generated Key: $key\n";

?>