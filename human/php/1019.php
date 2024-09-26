<?php
$unique_random_string = md5(uniqid(mt_rand(), true));
echo $unique_random_string;
?>