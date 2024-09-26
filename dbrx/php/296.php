<?php

use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class MyController extends Controller 
{
    /**
     * @IsGranted("my_permission")
     */
    public function myAction() 
    {
        // ...
        return new Response('Hello from myAction!');
    }

    /**
     * @IsGranted("another_permission")
     */
    public function anotherAction() 
    {
        // ...
        return new Response('Hello from anotherAction!');
    }
}