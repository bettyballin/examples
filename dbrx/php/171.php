<?php

namespace App\Controller;

use JMS\SecurityExtraBundle\Annotation\Secure;
use Symfony\Component\HttpFoundation\Response;

class MyController
{
    /**
     * @Secure(roles="ROLE_ADMIN")
     */
    public function someAction()
    {
        // ...
        return new Response('Hello, admin!');
    }
}