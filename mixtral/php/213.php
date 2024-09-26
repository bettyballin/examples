<?php

namespace AppBundle\Controller;

use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class SecurityController extends Controller
{
    public function logoAction()
    {
        // Log the user out
        $this->get('security.token_storage')->setToken(null);

        return new RedirectResponse($this->generateUrl('homepage'));

        /*
         * If you want to use route name instead of path
         * uncomment this line and comment above one
         */

        //return $this->redirectToRoute('homepage');
    }
}