
public function onInteractiveLogin(InteractiveLoginEvent $event)
{
    $user = $event->getAuthenticationToken()->getUser();
    
    // Check whether the user is an instance of your own User entity
    if ($user instanceof YourUserEntityClass) {
        // Assuming your User entity has a getLocale() method
        if (null !== $user->getLocale()) {
            $this->session->set('_locale', $user->getLocale());
        }
    }
    // If the user is not an instance of YourUserEntityClass, do nothing
}

