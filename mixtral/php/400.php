$token = $this->container->get('security.token_storage')->getToken();
if ($maintenance && !is_null($token)) {
    $role = $token->getRoles()[0]->getRole();
    if ($role !== 'ROLE_ADMIN') {
        throw new \Exception('Access denied. The site is under maintenance.');
    }
}