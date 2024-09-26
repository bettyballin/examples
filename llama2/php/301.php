// src/Security/Authentication/CustomAuthenticator.php

namespace App\Security\Authentication;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Security;
use Symfony\Component\Security\Core\Authentication\AuthenticationManagerInterface;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authentication\AuthenticationFailureHandlerInterface;
use Symfony\Component\Security\Core\Authentication\AuthenticationSuccessHandlerInterface;

class CustomAuthenticator implements AuthenticationListenerInterface, AuthenticationFailureHandlerInterface, AuthenticationSuccessHandlerInterface
{
    private $security;
    private $tokenStorage;
    private $authenticationManager;

    public function __construct(Security $security, TokenStorageInterface $tokenStorage, AuthenticationManagerInterface $authenticationManager)
    {
        $this->security = $security;
        $this->tokenStorage = $tokenStorage;
        $this->authenticationManager = $authenticationManager;
    }

    public function handleAuthentication(Request $request, TokenInterface $token)
    {
        // If the user has a role that grants access to the current page continue with the request
        if ($this->security->isGranted('ROLE_ADMIN')) {
            return;
        }

        // Redirect the user to the login page
        $loginUrl = $this->security->generateLoginUrl($request);
        return new RedirectResponse($loginUrl);
    }

    public function handleSuccessfulAuthentication(Request $request, TokenInterface $token)
    {
        // Get the previous URL from the session
        $previousUrl = $request->getSession()->get('_security.last_url');

        // Redirect the user to the previous URL
        return new RedirectResponse($previousUrl);
    }

    public function onAuthenticationFailure(Request $request, AuthenticationException $exception)
    {
        // Handle authentication failure
    }

    public function onAuthenticationSuccess(Request $request, TokenInterface $token)
    {
        // Handle authentication success
        return $this->handleSuccessfulAuthentication($request, $token);
    }
}