<?php
class Context {
    private $controller;

    public function getController() {
        return $this->controller;
    }

    public function setController($controller) {
        $this->controller = $controller;
    }
}

class Controller {
    private $action;

    public function getAction() {
        return $this->action;
    }

    public function setAction($action) {
        $this->action = $action;
    }
}

class Action {
    private $isSecure;

    public function isSecure() {
        return $this->isSecure;
    }

    public function setIsSecure($isSecure) {
        $this->isSecure = $isSecure;
    }
}

$context = new Context();
$controller = new Controller();
$action = new Action();

$action->setIsSecure(true);
$controller->setAction($action);
$context->setController($controller);

var_dump($context->getController()->getAction()->isSecure());