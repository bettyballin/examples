<?php

class SecurityContext {
    private $request;

    public function __construct() {
        $this->request = new stdClass();
    }

    public function getRequest() {
        return $this->request;
    }
}

class MyClass {
    private $request;

    public function __construct(SecurityContext $securityContext) {
        $this->request = $securityContext->getRequest();
    }
}

$securityContext = new SecurityContext();
$myClass = new MyClass($securityContext);

?>