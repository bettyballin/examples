<?php

use Symfony\Component\HttpFoundation\Session\Session;
use Symfony\Component\HttpFoundation\RedirectResponse;

if ($form->isValid() && !$this->getUser()) {
    $session = new Session();

    // Retrieve stored object
    if($data = unserialize($session->get('my_key')))
        return new RedirectResponse($this->generateUrl('registration'));

}

if ($form->isValid() && $this->getUser()) {

   // Unset the session data
   $session = new Session();
   $session->remove('my_key');

    if($data = unserialize($session->get('my_key')))
        return new RedirectResponse($this->generateUrl('registration'));

}