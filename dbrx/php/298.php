<?php

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class MyController extends Controller 
{
    /**
     * @Security("is_granted('my_permission')")
     */
    public function myAction() 
    {
        // ...
    }

    /**
     * @Security("is_granted('another_permission')")
     */
    public function anotherAction() 
    {
        // ...
    }
}