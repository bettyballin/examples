<?php

// Assuming you are in a Symfony controller
use Symfony\Component\HttpFoundation\Request;
use PhoneApplicationBundle\Entity\Application;
use PhoneApplicationBundle\Entity\User;

class MyController extends Controller
{
    public function myAction(Request $request, $idApplication)
    {
        // Get the app
        $application = $this->getDoctrine()->getRepository(Application::class)->find($idApplication);

        // Get the current user
        $user = $this->getUser();

        // Check if this user owns this app
        if ($user->getApplications()->contains($application)) {
            // Do your stuff
        } else {
            throw new \Exception('No right there!');
        }
    }
}