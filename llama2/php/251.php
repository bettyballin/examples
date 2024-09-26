<?php

use Drupal\Core\Password\PasswordValidatorInterface;

class CustomSHA256PasswordValidator implements PasswordValidatorInterface {

  public function validate(array $password, array $account) {
    // Hash the password using SHA256
    $hashed_password = hash('sha256', $password['value']);

    // Compare the hashed password with the stored value
    return ($hashed_password === $account['pass']) ? PasswordValidatorInterface::PASS : PasswordValidatorInterface::FAIL;
  }

}

// Usage example:
$passwordValidator = new CustomSHA256PasswordValidator();
$password = ['value' => 'testpassword'];
$account = ['pass' => hash('sha256', 'testpassword')];

$result = $passwordValidator->validate($password, $account);

if ($result === PasswordValidatorInterface::PASS) {
  echo "Password is valid.\n";
} else {
  echo "Password is invalid.\n";
}