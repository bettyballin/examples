$menu->addChild('user link', array('uri' => 'user'));
if ($this->securityAccessManager->isAdmin()) {
    $menu->addChild('admin link', array('uri' => 'admin'));
}