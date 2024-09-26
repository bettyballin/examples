<?php

use Drupal\Core\Module\Module;
use Drupal\Core\Password\PasswordValidatorManager;
use Drupal\Core\DependencyInjection\Container;

class MyModule extends Module {

  public function install() {
    // Register the custom password validator
    $container = \Drupal::getContainer();
    $password_validator_manager = $container->get('password.validator.manager');
    $password_validator_manager->registerValidator('custom_sha256', 'MyCustomSHA256PasswordValidator');
  }

}

class MyCustomSHA256PasswordValidator implements \Drupal\Core\Password\PasswordValidatorInterface {

  public function validate($password, $existing_hash) {
    // Custom validation logic here
  }

  public function hash($password) {
    // Custom hashing logic here
  }

  public function check($password, $hash) {
    // Custom checking logic here
  }

}