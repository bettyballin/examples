<?php
// assuming you are in a Symfony controller
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\Security\Core\SecurityContextInterface;
use Symfony\Component\HttpFoundation\Session\Session;

public function myAction()
{
    $token = // assume you have a token
    $session = new Session();
    $securityContext = $this->get('security.context');
    $securityContext->setToken($token);
    return new RedirectResponse($this->generateUrl('my_controller', array(
        'formValues' => $session->get('formValues')
    )));
}