<?php

use Symfony\Component\Security\Core\Authorization\Voter\Voter;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\SecurityContextInterface;

class SiteAccessVoter extends Voter
{
    const SITE_ACCESS = 'SITE_ACCESS';

    private $securityContext;

    public function __construct(SecurityContextInterface $securityContext)
    {
        $this->securityContext = $securityContext;
    }

    protected function supports($attribute, $subject)
    {
        return self::SITE_ACCESS === $attribute && is_object($subject);
    }

    protected function voteOnAttribute($attribute, $subject, TokenInterface $token)
    {
        if (!$this->securityContext || !$user = $token->getUser()) {
            // The user must be logged in; if not deny access.
            return false;
        }

        switch ($attribute) {
            case self::SITE_ACCESS:
                /** @var Site $subject */

                foreach($user->getSite() as $ownedSite){
                    // If the user owns this site grant access.
                    if($subject === $ownedSite){
                        return true;
                    }
                }

                /** @var User $user */

                foreach ($this->securityContext->getToken()->getRoles() as $role) {

                    // If the user is an admin grant access.

                    if ('ROLE_ADMIN' === $role->getRole()){
                        return true;
                    }
                }

                break;

            default:

                throw new \InvalidArgumentException(
                    sprintf('Unsupported attribute "%s"', $attribute)
                );

        }

        // If we didn't find a reason to grant access deny it.

        return false;
    }
}