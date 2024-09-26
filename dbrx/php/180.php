<?php

use Symfony\Component\Security\Core\SecurityContext;
use Symfony\Component\Security\Acl\Domain\ObjectIdentity;
use FOS\UserBundle\Model\UserManagerInterface;

class AclRemover
{
    private $securityContext;
    private $userManager;

    public function __construct(SecurityContext $securityContext, UserManagerInterface $userManager)
    {
        $this->securityContext = $securityContext;
        $this->userManager = $userManager;
    }

    public function removeAcl($oldUsername)
    {
        $aclProvider = $this->securityContext->getAclProvider();
        $user = $this->userManager->findUserByUsername($oldUsername);
        $objectIdentity = ObjectIdentity::fromDomainObject($user);
        $aclProvider->deleteAcl($objectIdentity);
    }
}

// Usage
$securityContext = new SecurityContext();
$userManager = new UserManager();
$aclRemover = new AclRemover($securityContext, $userManager);
$aclRemover->removeAcl('old_username');