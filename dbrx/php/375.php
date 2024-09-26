<?php

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\RedirectResponse;

class LoginController extends AbstractController
{
    public function login(Request $request): Response
    {
        if ($this->session->has('is_logged_in')) { 
            return new RedirectResponse($this->generateUrl('home'));
        }

        // Handle form submission and authentication.
        return new Response('Please login');
    }
}