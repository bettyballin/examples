
// Assuming $user is the user entity that you've just updated.
$token = new UsernamePasswordToken($user, null, 'main', $user->getRoles());
$this->container->get('security.token_storage')->setToken($token);

// Now, you may also want to update the session with the new roles.
$session = $this->container->get('session');
$session->set('_security_main', serialize($token
