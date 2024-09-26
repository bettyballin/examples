<?php
$hash1 = hash('sha1', 'The string to hash by SHA-1');
$hash2 = hash('sha256', 'The string to hash by SHA-256');
$hash3 = hash('sha512', 'The string to hash by SHA-512');
$hash4 = hash('ripemd160', 'The string to hash by RIPEMD-160');

print("SHA-1: $hash1\n");
print("SHA-256: $hash2\n");
print("SHA-512: $hash3\n");
print("RIPEMD-160: $hash4\n");
?>