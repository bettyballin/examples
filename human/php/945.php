function SetString($stringValue, &$dest, $slen) {
    $dest = substr($stringValue, 0, $slen);
}

function Base64Encode2($stringValue) {
    return base64_encode($stringValue);
}

$dest = '';
.setString('Hello, World!', $dest, 13);
$result = Base64Encode2($dest);
print($result);