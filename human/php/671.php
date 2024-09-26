<?php

class Service {
    public function yourFunctionOfTheService() {
        echo "Service function executed!";
    }
}

class Main {
    private $container;

    public function __construct() {
        $this->container = new stdClass();
        $this->container->nameoftheservice = new Service();
    }

    public function get($service) {
        return $this->container->$service;
    }

    public function run() {
        $serv = $this->get('nameoftheservice');
        $serv->yourFunctionOfTheService();
    }
}

$main = new Main();
$main->run();

?>