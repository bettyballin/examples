<?php

use Symfony\Component\Security\Core\Access\Voter\VoterInterface;
use Symfony\Component\Security\Core\User\UserInterface;
use sfGuardPlugin\sfGuardUser;
use Symfony\Component\Security\Core\SecurityContext;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;

class TypePropertyVoter implements VoterInterface
{
    private $securityContext;

    public function __construct(SecurityContext $securityContext)
    {
        $this->securityContext = $securityContext;
    }

    public function vote(TokenInterface $token, $object, array $attributes)
    {
        // Get the user from the security context
        $user = $this->securityContext->getUser();

        if (!$user instanceof UserInterface) {
            return VoterInterface::ACCESS_DENIED;
        }
    }
}