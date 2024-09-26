<?php

function md5($message) {
    // Constants for MD5 algorithm
    $s11 = 7;
    $s12 = 12;
    $s13 = 17;
    $s14 = 22;

    // MD5 functions
    function FF($a, $b, $c, $d, $x, $s, $ac) {
        return rotate_left($a + f($b, $c, $d) + $x + $ac, $s);
    }

    function GG($a, $b, $c, $d, $x, $s, $ac) {
        return rotate_left($a + g($b, $c, $d) + $x + $ac, $s);
    }

    function HH($a, $b, $c, $d, $x, $s, $ac) {
        return rotate_left($a + h($b, $c, $d) + $x + $ac, $s);
    }

    function II($a, $b, $c, $d, $x, $s, $ac) {
        return rotate_left($a + i($b, $c, $d) + $x + $ac, $s);
    }

    // Rotate left
    function rotate_left($num, $shift) {
        return (($num << $shift) | ($num >> (32 - $shift)));
    }

    // Functions for MD5 algorithm
    function f($b, $c, $d) {
        return ($b & $c) | ((~$b) & $d);
    }

    function g($b, $c, $d) {
        return ($b & $d) | ($c & (~$d));
    }

    function h($b, $c, $d) {
        return $b ^ $c ^ $d;
    }

    function i($b, $c, $d) {
        return $c ^ ($b | (~$d));
    }

    // Initialize variables
    $a = 0x67452301;
    $b = 0xefcdab89;
    $c = 0x98badcfe;
    $d = 0x10325476;

    // Preprocess the message
    $message = str_pad($message, strlen($message) + 56, "\x00");
    $bit_len = strlen($message) * 8;
    $bit_len_str = pack("N*", $bit_len);
    $message .= substr($bit_len_str, 0, 4);

    // Process the message in blocks
    for ($i = 0; $i < strlen($message); $i += 64) {
        $block = substr($message, $i, 64);
        $w = array();
        for ($j = 0; $j < 16; $j++) {
            $w[] = unpack("N", substr($block, $j * 4, 4))[1];
        }

        $aa = $a;
        $bb = $b;
        $cc = $c;
        $dd = $d;

        $a = FF($a, $b, $c, $d, $w[0], $s11, 0xd76aa478);
        $d = FF($d, $a, $b, $c, $w[1], $s12, 0xe8c7b756);
        $c = FF($c, $d, $a, $b, $w[2], $s13, 0x242070db);
        $b = FF($b, $c, $d, $a, $w[3], $s14, 0xc1bdceee);
        $a = FF($a, $b, $c, $d, $w[4], $s11, 0xf57c0faf);
        $d = FF($d, $a, $b, $c, $w[5], $s12, 0x4787c62a);
        $c = FF($c, $d, $a, $b, $w[6], $s13, 0xa8304613);
        $b = FF($b, $c, $d, $a, $w[7], $s14, 0xfd469501);
        $a = FF($a, $b, $c, $d, $w[8], $s11, 0x698098d8);
        $d = FF($d, $a, $b, $c, $w[9], $s12, 0x8b44f7af);
        $c = FF($c, $d, $a, $b, $w[10], $s13, 0xffff5bb1);
        $b = FF($b, $c, $d, $a, $w[11], $s14, 0x895cd7be);
        $a = FF($a, $b, $c, $d, $w[12], $s11, 0x6b901122);
        $d = FF($d, $a, $b, $c, $w[13], $s12, 0xfd987193);
        $c = FF($c, $d, $a, $b, $w[14], $s13, 0xa679438e);
        $b = FF($b, $c, $d, $a, $w[15], $s14, 0x49b40821);

        $a = GG($a, $b, $c, $d, $w[1], $s12, 0xf61e2562);
        $d = GG($d, $a, $b, $c, $w[6], $s13, 0xc040b340);
        $c = GG($c, $d, $a, $b, $w[11], $s14, 0x265e5a51);
        $b = GG($b, $c, $d, $a, $w[0], $s11, 0xe9b6c7aa);
        $a = GG($a, $b, $c, $d, $w[5], $s12, 0xd62f105d);
        $d = GG($d, $a, $b, $c, $w[10], $s13, 0x02441453);
        $c = GG($c, $d, $a, $b, $w[15], $s14, 0xd8a1e681);
        $b = GG($b, $c, $d, $a, $w[4], $s11, 0xe7d3fbc8);
        $a = GG($a, $b, $c, $d, $w[9], $s12, 0x21e1cde6);
        $d = GG($d, $a, $b, $c, $w[14], $s13, 0xc33707d6);
        $c = GG($c, $d, $a, $b, $w[3], $s14, 0xf4d50d87);
        $b = GG($b, $c, $d, $a, $w[8], $s11, 0x455a14ed);
        $a = GG($a, $b, $c, $d, $w[13], $s12, 0xa9e3e905);
        $d = GG($d, $a, $b, $c, $w[2], $s13, 0xfcefa3f8);
        $c = GG($c, $d, $a, $b, $w[7], $s14, 0x676f02d9);
        $b = GG($b, $c, $d, $a, $w[12], $s11, 0x8d2a4c8a);

        $a = HH($a, $b, $c, $d, $w[5], $s12, 0xfffa3942);
        $d = HH($d, $a, $b, $c, $w[8], $s13, 0x8771f681);
        $c = HH($c, $d, $a, $b, $w[11], $s14, 0x6d9d6122);
        $b = HH($b, $c, $d, $a, $w[14], $s11, 0xfde5380c);
        $a = HH($a, $b, $c, $d, $w[1], $s12, 0xa4beea44);
        $d = HH($d, $a, $b, $c, $w[4], $s13, 0x4bdecfa9);
        $c = HH($c, $d, $a, $b, $w[7], $s14, 0xf6bb4b60);
        $b = HH($b, $c, $d, $a, $w[10], $s11, 0xbebfbc70);
        $a = HH($a, $b, $c, $d, $w[13], $s12, 0x289b7ec6);
        $d = HH($d, $a, $b, $c, $w[0], $s13, 0xeaa127fa);
        $c = HH($c, $d, $a, $b, $w[3], $s14, 0xd4ef3085);
        $b = HH($b, $c, $d, $a, $w[6], $s11, 0x04881d05);
        $a = HH($a, $b, $c, $d, $w[9], $s12, 0xd9d4d039);
        $d = HH($d, $a, $b, $c, $w[12], $s13, 0xe6db99e5);
        $c = HH($c, $d, $a, $b, $w[15], $s14, 0x1fa27cf8);
        $b = HH($b, $c, $d, $a, $w[2], $s11, 0xc4ac5665);

        $a = II($a, $b, $c, $d, $w[0], $s12, 0xf4292244);
        $d = II($d, $a, $b, $c, $w[7], $s13, 0x432aff97);
        $c = II($c, $d, $a, $b, $w[14], $s14, 0xab9423a7);
        $b = II($b, $c, $d, $a, $w[5], $s11, 0xfc93a039);
        $a = II($a, $b, $c, $d, $w[12], $s12, 0x655b59c3);
        $d = II($d, $a, $b, $c, $w[3], $s13, 0x8f0ccc92);
        $c = II($c, $d, $a, $b, $w[10], $s14, 0xffeff47d);
        $b = II($b, $c, $d, $a, $w[1], $s11, 0x85845dd1);
        $a = II($a, $b, $c, $d, $w[8], $s12, 0x6fa87e4f);
        $d = II($d, $a, $b, $c, $w[15], $s13, 0xfe2ce6e0);
        $c = II($c, $d, $a, $b, $w[6], $s14, 0xa3014314);
        $b = II($b, $c, $d, $a, $w[13], $s11, 0x4e0811a1);
        $a = II($a, $b, $c, $d, $w[4], $s12, 0xf7537e82);
        $d = II($d, $a, $b, $c, $w[11], $s13, 0xbd3af235);
        $c = II($c, $d, $a, $b, $w[2], $s14, 0x2ad7d2bb);
        $b = II($b, $c, $d, $a, $w[9], $s11, 0xeb86d391);

        $a = ($a + $aa) & 0xffffffff;
        $b = ($b + $bb) & 0xffffffff;
        $c = ($c + $cc) & 0xffffffff;
        $d = ($d + $dd) & 0xffffffff;
    }

    $result = sprintf("%08x%08x%08x%08x", $a, $b, $c, $d);
    return $result;
}

$message = "Hello, World!";
echo md5($message);

?>