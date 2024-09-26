<?php
require_once 'vendor/autoload.php';

use PasswordLib\PasswordLib;

$hasher = new PasswordLib(array('algorithm' => 'bcrypt', 'cost' => 10));