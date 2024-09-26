<?php

namespace App\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Response;

class DemoController extends Controller
{
    /**
     * @Security("has_role('IS_AUTHENTICATED_FULLY')")
     */
    public function indexAction()
    {
        return new Response('Hello, authenticated user!');
    }
}