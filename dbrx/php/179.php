<?php

use Symfony\Component\Security\Core\SecurityContext;
use Symfony\Component\Security\Acl\Model\ObjectIdentity;
use Symfony\Component\Security\Acl\Model\UserSecurityIdentity;
use FOS\UserBundle\Model\UserManager;

$securityContext = $this->get('security.context');
$aclProvider = $securityContext->getAclProvider();
$userManager = $this->get('fos_user.user_manager');

// Get the user and their old username
$oldUsername = 'old_username'; // replace with the actual old username
$user = $userManager->findUserByUsername($oldUsername);
$oldSecurityIdentity = new ObjectIdentity('My\\Bundle\\Entity\\User-' . $oldUsername, 1);

// Create a new security identity with the updated username
$newSecurityIdentity = new UserSecurityIdentity(
    $user->getUsername(),
    get_class($user)
);

// Update all of your ACEs to use the user's current username instead.
$aclProvider->updateSecurityIdentity($newSecurityIdentity, array($oldSecurityIdentity));