use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\Security\Core\SecurityContext;

// In your login action
if ($request->attributes->has(SecurityContext::AUTHENTICATION_ERROR)) {
  $error = $request->attributes->get(SecurityContext::AUTHENTICATION_ERROR);
} else if (null !== $app['security.last_username']) {
    // The user has submitted the login form but it was not valid

   // Here you can redirect to previous page
  return new RedirectResponse($request->headers->get('referer'));
}