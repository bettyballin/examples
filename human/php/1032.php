$str = "your string here";
$len = strlen($str);
$pad = ord($str[$len-1]);
$str = substr($str, 0, $len - $pad);