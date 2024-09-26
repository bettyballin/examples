$aclProvider = $this->get('security.acl_provider');

$oldUsername = 'shigeno';
$newUsername = 'honda';

$userOld = $this->getDoctrine()->getRepository('AppBundle:User')->findOneByUsername($oldUsername);
$userNew = $this->getDoctrine()->getRepository('AppBundle:User')->findOneByUsername($newUsername);
if (!$userNew) {
    $userNew = new \AppBundle\Entity\User();
    $userNew->setUsername($newUsername);
}

try {
    $aclProvider->updateUserSecurityIdentity($userOld, $userNew);
} catch (\Symfony\Component\Security\Acl\Exception\InvalidDomainObjectException $e) {}