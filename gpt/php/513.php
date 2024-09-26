
    private function isGrantedToDelete($targetUser)
    {
        $securityContext = $this->container->get('security.authorization_checker');
        $roleHierarchy = $this->container->get('security.role_hierarchy');
        $currentUserRoles = $securityContext->getToken()->getRoles();
        $map = $roleHierarchy->getReachableRoleNames($currentUserRoles);

        foreach ($targetUser->getRoles() as $role) {
            if (in_array($role, $map)) {
                return false; // Target user has a role equal to or higher than current user
            }
       
