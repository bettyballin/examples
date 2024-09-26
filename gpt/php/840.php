
$str = 'hello';
$raw_md5 = md5($str, true); // The second parameter 'true' tells md5 to return raw binary data
$base64_md5 = base64_encode($raw_md5);
echo $base64_md5; // Should output "XUFAKrxLKna5cZ2REBfFkg=="

