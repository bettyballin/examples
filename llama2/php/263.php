<?php

use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authorization\Voter\VoterInterface;

class DynamicRoleVoter implements VoterInterface
{
    private $roleHierarchy;

    public function __construct(array $roleHierarchy)
    {
        $this->roleHierarchy = $roleHierarchy;
    }

    public function vote(TokenInterface $token, $object, array $attributes)
    {
        // Get the current user's groups
        $groups = $token->getUser()->getGroups();

        // Check if the required roles are met
        foreach ($attributes as $attribute) {
            $requiredRoles = explode(',', $attribute);

            // If any of the required roles match a group the user is in, grant access
            if (count(array_intersect($groups, $requiredRoles)) > 0) {
                return VoterInterface::ACCESS_GRANTED;
            }
        }

        // No matching role found, deny access
        return VoterInterface::ACCESS_DENIED;
    }

    public function supportsAttribute($attribute)
    {
        // Support any attribute
        return true;
    }

    public function supportsClass($class)
    {
        // Support any class
        return true;
    }
}