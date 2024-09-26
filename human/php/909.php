$user->setRoles(array("ROLE_DRIVER"));
$entityManager->persist($user);
$entityManager->flush();