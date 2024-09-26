<?php

class SessionRenewer {
    private $session;

    public function __construct($session) {
        $this->session = $session;
    }

    public function renewSession($request) {
        if ($request->headers->get('X-Requested-With') === 'XMLHttpRequest') {
            // Renew session
            $this->session->renew();
        }
    }
}

// Assuming Symfony framework
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Session\Session;

$request = new Request();
$session = new Session();

$sessionRenewer = new SessionRenewer($session);
$sessionRenewer->renewSession($request);