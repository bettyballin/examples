<?php

use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\PasswordType;
use Symfony\Component\Security\Csrf\CsrfToken;
use Symfony\Component\Security\Csrf\CsrfTokenBadge;

$form = $this->get('form.factory')->createNamedBuilder('loginForm')
    ->add('username', TextType::class)
    ->add('password', PasswordType::class)
    ->getForm();

$csrfToken = $this->get('security.csrf.token_manager')->getToken($form->getName());
$badge = new CsrfTokenBadge($form->getId(), $csrfToken);