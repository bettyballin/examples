<?php
function cryptoJsBase64Encode($data) {
    $encoded = strtr(base64_encode($data), '+/', '-_');
    return rtrim($encoded, '=');
}

$str = 'hello';
$md5 = md5($str, true); 
$result = cryptoJsBase64Encode($md5);

echo $result; 
?>