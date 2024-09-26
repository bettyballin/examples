private function loginUser(Request $request, UserInterface $user) : void
{
    $token = new UsernamePasswordToken($user, null, 'main', $user->getRoles());
    $this->tokenStorage->setToken($token);

    $event = new InteractiveLoginEvent($request, $token);
    $this->eventDispatcher->dispatch(SecurityEvents::INTERACTIVE_LOGIN, $event);
}