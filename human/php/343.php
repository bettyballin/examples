<?php
if (defined('MCRYPT_DEV_URANDOM')) {
    function generateSecureKey($length) {
        return mcrypt_create_iv($length, MCRYPT_DEV_URANDOM);
    }
    echo generateSecureKey(16);
} else {
    throw new Exception("I cannot generate a secure pseudo-random key. Please use PHP >= 5.3 or Mcrypt extension");
}
?>