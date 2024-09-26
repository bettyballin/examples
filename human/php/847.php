<?php

namespace Company\Bundle\nameBundle\Controller;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DashPrivateImageController extends Controller
{
    public function getImageAction($imagetype, $imagename) {

        $securityContext = $this->container->get('security.context');

        if ($securityContext->isGranted('IS_AUTHENTICATED_REMEMBERED')) {

            if ($imagetype == 1) 
                $path = $this->get('kernel')->getRootDir() . "/../private/documentFolder1/" . $imagename;
            else 
                $path = $this->get('kernel')->getRootDir() . "/../private/documentFolder2/" . $imagename;

            $file = file_get_contents($path);
            $headers = array('Content-Type' => 'image/jpeg', 
                       'Content-Disposition' => 'inline; filename="'.$imagename.'"');
            return new Response($file, 200, $headers);
        } else 
            return new Response("not found", 404);
    }
}
?>