<?php
$options = array('cost' => 8); // 2^cost is the number of iterations 
$hash = password_hash("adsfasdf", PASSWORD_BCRYPT, $options);
print($hash);
?>