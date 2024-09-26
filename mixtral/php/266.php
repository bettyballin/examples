<?php

// src\Controller\ExceptionController.php

namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;

class ExceptionController extends Controller
{
    public function showAction(Request $request, \Exception $exception)
    {
        return new Response($this->renderView('TwigBundle:Exception:error.html.twig', array('exception' => $exception)));
    }
}