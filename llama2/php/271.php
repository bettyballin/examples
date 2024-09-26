<?php

class MyClass {
    private $session;

    public function myMethod() {
        $session = $this->getSession();
        return $this->redirect($this->generateUrl('register', array(
            'formValues' => $session->get('formValues')
        )));
    }

    private function getSession() {
        // assuming you are using Symfony
        return $this->get('session');
    }

    private function generateUrl($route, $parameters) {
        // assuming you are using Symfony
        return $this->get('router')->generate($route, $parameters);
    }

    private function redirect($url) {
        // assuming you are using Symfony
        return $this->get('redirect')->redirect($url);
    }
}

$myClass = new MyClass();
$myClass->myMethod();

?>