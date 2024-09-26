<?php

require "Uint.php";
require "Blake2b.php";

// publick key
$public_key = "3068bb1ca04525bb0e416c485fe6a67fd52540227d267cc8b6e8da958a7fa039";
$key = Uint::fromHex('0' . $public_key);
$key_base32 = $key->toString();
print($key_base32 . PHP_EOL);

// checksum
$blake40 = new Blake2b(5);
$hash = $blake40->hash(hex2bin($public_key));
$check = Uint::fromHex(bin2hex($hash))->reverse();
$check_base32 = $check->toString();
print($check_base32 . PHP_EOL);

print('nano_' . $key_base32 . $check_base32 . PHP_EOL); // nano_1e5aqegc1jb7qe964u4adzmcezyo6o146zb8hm6dft8tkp79za3sxwjym5rx

?>