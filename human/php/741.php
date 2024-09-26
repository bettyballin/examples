<?php

class ConfigProvider
{
    public function getConfiguration()
    {
        // example configuration
        return [
            'line1',
            'line2',
            'line3',
        ];
    }
}

class MyService
{
    protected $provider;

    public function __construct(ConfigProvider $provider)
    {
        $this->provider = $provider;
    }

    public function doAction()
    {
        $access = $this->provider->getConfiguration();

        foreach ($access as $line) {
            echo "$line\n";
        }
    }
}

$provider = new ConfigProvider();
$service = new MyService($provider);
$service->doAction();

?>