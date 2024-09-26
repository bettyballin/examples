<?php

require_once 'vendor/autoload.php';

use Symfony\Component\Yaml\Yaml;

class ConfigProvider
{
    protected $rootDir;

    public function __construct($rootDir)
    {
        $this->rootDir = $rootDir;
    }

    public function getConfiguration()
    {
        $file = sprintf(
            "%s/config/security.yml",
            $this->rootDir
        );
        $parsed = Yaml::parse(file_get_contents($file));

        return $parsed['security']['access_control'];
    }
}

$configProvider = new ConfigProvider(__DIR__);
$config = $configProvider->getConfiguration();

print_r($config);