<?php

namespace App\Controller;

use JMS\SecurityExtraBundle\Annotation\Secure;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Templating\Annotation\Template;

class SiteController extends Controller
{
    /**
     * @Route("/site/{id}", name="site_show")
     * @Template()
     * @Secure(roles="ROLE_ADMIN", expr="user and user.isOwner(site)")
     */
    public function showAction(Site $site)
    {
        // your code here
        return array('site' => $site);
    }
}