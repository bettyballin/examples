Here is the executable PHP code:


<?php

namespace AppBundle\Security\Voter;

use AppBundle\Entity\User\Associate;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authorization\Voter\VoterInterface;
use Symfony\Component\Security\Core\Role\RoleHierarchy;
use Symfony\Component\Security\Core\User\UserInterface;

class ManagerVoter implements VoterInterface
{
    const SELECT_ASSOCIATES = 'select_associates';
    const ACCESS_GRANTED = 1;
    const ACCESS_DENIED = -1;
    const ACCESS_ABSTAIN = 0;

    private $roleHierarchy;

    public function __construct(RoleHierarchy $roleHierarchy)
    {
        $this->roleHierarchy = $roleHierarchy;
    }

    protected function hasRole(TokenInterface $token, $targetRole)
    {
        $reachableRoles = $this->roleHierarchy->getReachableRoles($token->getRoles());
        foreach($reachableRoles as $role)
        {
            if ($role->getRole() == $targetRole) return true;
        }
        return false;
    }

    protected function getSupportedClasses()
    {
        return array(
            'AppBundle\Entity\User\Associate',
        );
    }

    protected function getSupportedAttributes()
    {
        return array(self::SELECT_ASSOCIATES);
    }

    public function vote(TokenInterface $token, $object, array $attributes)
    {
        if (!$object || !$this->supportsClass(get_class($object))) {
            return self::ACCESS_ABSTAIN;
        }

        $vote = self::ACCESS_ABSTAIN;

        foreach ($attributes as $attribute) {
            if (!$this->supportsAttribute($attribute)) {
                continue;
            }

            $vote = self::ACCESS_DENIED;

            if ($this->isGranted($attribute, $object, $token)) {
                return self::ACCESS_GRANTED;
            }
        }

        return $vote;
    }

    protected function isGranted($attribute, $object, TokenInterface $token)
    {
        $user = $token->getUser();
        $associateRoles = $object->getRoles();

        if (!$user instanceof UserInterface) {
            return false;
        }

        if ($attribute == self::SELECT_ASSOCIATES) {
            if (in_array('ROLE_COMPANY_STAFF',$associateRoles))
            {
                if ($this->hasRole($token, 'ROLE_COMPANY_MANAGER'))
                {
                    return true;
                }
            }
            elseif (in_array('ROLE_BOUTIQUE_STAFF',$associateRoles))
            {
                if ($this->hasRole($token, 'ROLE_BOUTIQUE_MANAGER'))
                {
                    return true;
                }
            }
            elseif (in_array('ROLE_SCHOOL_STAFF',$associateRoles))
            {
                if ($this->hasRole($token, 'ROLE_PROFESSOR'))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public function supportsAttribute($attribute)
    {
        return in_array($attribute, $this->getSupportedAttributes());
    }

    public function supportsClass($class)
    {
        foreach ($this->getSupportedClasses() as $supportedClass) {
            if ($supportedClass === $class || is_subclass_of($class, $supportedClass)) {
                return true;
            }
        }

        return false;
    }
}