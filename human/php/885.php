<?php

require 'vendor/autoload.php';

use Symfony\Component\Yaml\Yaml;

$file = sprintf("%s/config/security.yml", __DIR__);
$parsed = Yaml::parse(file_get_contents($file));

$access = $parsed['security']['access_control'];

print_r($access);


Note: Make sure to install the `symfony/yaml` package via Composer by running `composer require symfony/yaml` in your terminal.