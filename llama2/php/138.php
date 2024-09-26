<?php

// ...

if ($this->get('security.authorization_checker')->isGranted('ROLE_PREMIUM')) {
    return $this->render('FOSUserBundle:Security:logoutPremium.html.twig');
}