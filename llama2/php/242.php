<?php

class Controller {
    public function beforeFilter() {
        Security::setBlackHole(false);
    }
}

class Security {
    public static function setBlackHole($value) {
        // Implementation of setBlackHole method
    }
}

$obj = new Controller();
$obj->beforeFilter();