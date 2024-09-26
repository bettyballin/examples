<?php

function myHmac(string $data, string $key, callable $algofn, int $blockSize): string
{
    if (strlen($key) > $blockSize){
        // keys longer than blocksize are shortened
        $key = hash($algofn, $key);
    }

    if(strlen($key) < $blockSize){
        //keys shorter than blocksizes are zero-padded
        $key .= str_repeat("\0", $blockSize - strlen($key));
    }

    $outerKeyPad = "";
    for ($i=0;$i<$blockSize;++$i) {
        $outerKeyPad .= chr(ord("\x5c") ^ ord($key[$i]));
    }

    $innerKeyPad = "";
    for ($i=0;$i<$blockSize;++$i){
        $innerKeyPad .= chr(ord("\x36") ^ ord($key[$i]));
    }

    return bin2hex(hash($algofn, $outerKeyPad . hash($algofn, $innerKeyPad.$data)));
}

// Example usage:
$algofn = 'sha256';
$data = 'Hello, World!';
$key = 'my_secret_key';
$blockSize = 64;

echo myHmac($data, $key, $algofn, $blockSize);

?>