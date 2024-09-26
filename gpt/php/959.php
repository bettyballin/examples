
// ... [Your existing code] ...

// After the user is saved, log them in automatically
$token = new UsernamePasswordToken($user, null, 'main', $user->getRoles());
$this->container->get('security.token_storage')->setToken($token);
$this->container->get('session')->set('_security_main', serialize($token));

// If you want to dispatch login event (optional, Symfony 4.4+)
// $event = new InteractiveLoginEvent($request, $token);
// $this->container->get('event_dispatcher')->dispatch("security.interactive_login", $event);

// Redirect user or return your response
return $this->redirectToRoute('index');

