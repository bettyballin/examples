<?php

class SecurityController extends Controller
{
    public function getRolesAction()
    {
        $user = $this->getUser();
        if ($user) {
            // Get the roles for this specific logged in user
            $roles = $user->getRoles();
            var_dump($roles);
        }

        // Or to get all available application-wide roles
        $securityContext = $this->container->get('security.authorization_checker');
        if ($securityContext instanceof AuthorizationChecker) {
            // Get the role hierarchy
            $roleHierarchy = $this->container->getParameter('security.role_hierarchy');
            var_dump($roleHierarchy);
        }
    }
}