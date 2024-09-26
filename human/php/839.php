<?php

class Router {
    const SECRET_KEY_PARAM_NAME = 'secret_key';

    private function getRouteName() {
        // implementation of getRouteName method
    }

    private function getControllerName() {
        // implementation of getControllerName method
    }

    private function getDefaultControllerName() {
        // implementation of getDefaultControllerName method
    }

    private function getActionName() {
        // implementation of getActionName method
    }

    private function getDefaultActionName() {
        // implementation of getDefaultActionName method
    }

    private function getSecretKey($controller, $action) {
        // implementation of getSecretKey method
    }

    public function execute($cacheSecretKey) {
        $_route = $this->getRouteName() ? $this->getRouteName() : '*';
        $_controller = $this->getControllerName() ? $this->getControllerName() : $this->getDefaultControllerName();
        $_action = $this->getActionName() ? $this->getActionName() : $this->getDefaultActionName();

        if ($cacheSecretKey) {
            $secret = array(self::SECRET_KEY_PARAM_NAME => "${$_controller}/{$_action}$");
        }
        else {
            $secret = array(self::SECRET_KEY_PARAM_NAME => $this->getSecretKey($_controller, $_action));
        }

        // do something with $secret
    }
}

$router = new Router();
$router->execute(true);