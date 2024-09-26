<?php

use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class MyController extends Controller 
{
    /**
     * @IsGranted("my_permission", subject="user")
     */
    public function myAction(User $user) 
    {
        // ...
        return new Response('Hello, World!');
    }

    /**
     * @IsGranted("another_permission", subject="post")
     */
    public function anotherAction(Post $post) 
    {
        // ...
        return new Response('Hello, World!');
    }
}