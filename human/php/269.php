<?php
$secret = '7e41520667dc20457db2f18644bad06dd62a2120be8b93cd5596d8ffea45ef0f';
$key = '_My-16-byte-key_';

print mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, pack('H*', $secret), 'ecb');
?>