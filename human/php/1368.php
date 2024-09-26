<?php
$hash = hash_init("md5");
$data1="ABCD";
hash_update($hash, $data1);
$data2="ABCD";
hash_update($hash, $data2);
print(hash_final($hash));
?>