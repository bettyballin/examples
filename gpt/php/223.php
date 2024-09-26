
<?php
// Assuming you have retrieved $encryptedData and $iv from the database and you have the $encryption_key
$decryptedData = openssl_decrypt($encryptedData, 'aes-
