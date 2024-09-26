public function onInteractiveLogin(InteractiveLoginEvent $event)
{
   $user = $event->getAuthenticationToken()->getUser();

   if ( $user instanceof App\Entity\User && null !== $user->getLocale()) {
      $this->session->set('_locale', $user->getLocale());
   }
}