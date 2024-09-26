<?php

use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Acl\Model\ObjectIdentity;
use Symfony\Component\Security\Acl\Model\MutableAclInterface;
use Symfony\Component\Security\Acl\Permission\MaskBuilder;

$aclProvider = $this->get('security.acl_provider');

// Get User object
$usernameToDelete = 'shigeno';
$user = // retrieve the User object from database or any other source

try {
    // Fetch or create an ACL for the given user
    $objectIdentity = ObjectIdentity::fromDomainObject($user);

    if ($aclProvider->isAclEnabled()) {
        try {
            $aclManager = new PhpAclManager();

            foreach (['VIEW', 'EDIT'] as $mask) {
                // Remove the ACL entry for this user
                $aclManager->deleteObjectIdentity($objectIdentity, $usernameToDelete);

                if ($user instanceof UserInterface && in_array('ROLE_ADMIN', $user->getRoles())) {
                    throw new \Exception("Cannot delete an admin's ACL entry.");
                }
            }
        } catch (\Symfony\Component\Security\Acl\Model\MutableAclInterface $e) {}

        // Remove the user object from database
        try {
            // assuming you have an EntityManager
            $em = $this->getDoctrine()->getManager();
            $em->remove($user);
            $em->flush();
        } catch (\Exception $e) {
            // handle the exception
        }
    }
} catch (\Exception $e) {
    // handle the exception
}