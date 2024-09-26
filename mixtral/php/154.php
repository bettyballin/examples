<?php

class Hasher {
    public function createPassword($plaintext_password) {
        return password_hash($plaintext_password, PASSWORD_DEFAULT);
    }
}

$hasher = new Hasher();
$plaintext_password = "mysecretpassword";
$hashed_password = $hasher->createPassword($plaintext_password);

print($hashed_password);

?>