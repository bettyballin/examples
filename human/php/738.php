<?php

require_once 'vendor/autoload.php';

use Symfony\Component\Yaml\Yaml;

$kernelRootDir = __DIR__.'/app';
$file   = sprintf("%s/config/security.yml", $kernelRootDir);
$parsed = Yaml::parse(file_get_contents($file));

$access = $parsed['security']['access_control'];

print_r($access);