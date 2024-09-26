<?php
class Hasher {
    public function validatePassword($plaintext_password, $stored_hash) {
        return password_verify($plaintext_password, $stored_hash);
    }
}

$hasher = new Hasher();
$plaintext_password = 'your_password';
$stored_hash = password_hash('your_password', PASSWORD_DEFAULT);

if ($hasher->validatePassword($plaintext_password, $stored_hash)) {
    echo "The provided password is correct";
} else {
    echo "Incorrect password";
}
?>