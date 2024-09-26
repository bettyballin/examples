<?php
function blowfishEncrypt($string,$rounds) {
        $salt = "";
        $saltCharacters = array_merge(range('A','Z'),range('a','z'),range(0,9));
        for ($i=0;$i<22;$i++) {
            $salt .= $saltCharacters[array_rand($saltCharacters)];
        }
        $hashstring = crypt($string,'$2y$' . $rounds . '$' . $salt);

        return $hashstring;
    }

// Example usage:
$string = "Hello, World!";
$rounds = 12;
echo blowfishEncrypt($string, $rounds);
?>