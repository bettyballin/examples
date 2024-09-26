public function onInteractiveLogin(InteractiveLoginEvent $event)
{
    $user = $event->getAuthenticationToken()->getUser();

    // Check if current logged-in user implements AppUserInterface
    if ($user instanceof \App\Security\AppUserInterface && null !== $user->getLocale()) {
        $this->session->set('_locale', $user->getLocale());
    }
}