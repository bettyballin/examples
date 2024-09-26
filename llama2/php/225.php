$acl = $this->get('security.context')->createAcl();
$acl->setName($newUsername);

// assuming you have roles and permissions defined
$acl->addRole(new \Symfony\Component\Security\Core\Role\Role('ROLE_USER'));
$acl->addRole(new \Symfony\Component\Security\Core\Role\Role('ROLE_ADMIN'));

// create permissions
$permission1 = new \Symfony\Component\Security\Acl\Permission\MaskBuilder();
$permission1->add('view');
$permission1->add('edit');

$permission2 = new \Symfony\Component\Security\Acl\Permission\MaskBuilder();
$permission2->add('view');
$permission2->add('delete');

// add permissions to roles
$acl->insertObjectAce(new \Symfony\Component\Security\Acl\Domain\ObjectIdentity('class', 'MyClass'), $permission1->get(), 0, false, new \Symfony\Component\Security\Core\Role\RoleSecurityIdentity('ROLE_USER'));
$acl->insertObjectAce(new \Symfony\Component\Security\Acl\Domain\ObjectIdentity('class', 'MyClass'), $permission2->get(), 0, false, new \Symfony\Component\Security\Core\Role\RoleSecurityIdentity('ROLE_ADMIN'));

// save the ACL
$aclProvider = $this->get('security.acl.provider');
$aclProvider->updateAcl($acl);