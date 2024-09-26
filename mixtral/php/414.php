<?php

use Symfony\Component\Security\Core\Authentication\Token\RememberMeToken;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authentication\AuthenticationManagerInterface;
use Symfony\Component\Security\Core\Authentication\RememberMe\TokenBasedRememberMeServices;
use Symfony\Component\Security\Core\Authentication\RememberMe\RememberMeServiceInterface;
use Symfony\Component\Security\Core\Exception\RuntimeException;
use Symfony\Component\HttpFoundation\Request;
use App\Security\AppCustomAuthenticator;

class SecurityController
{
    private $tokenStorage;
    private $authenticationManager;
    private $rememberMeService;
    private $guardHandler;

    public function __construct(
        TokenStorageInterface $tokenStorage,
        AuthenticationManagerInterface $authenticationManager,
        RememberMeServiceInterface $rememberMeService,
        GuardAuthenticatorHandler $guardHandler
    ) {
        $this->tokenStorage = $tokenStorage;
        $this->authenticationManager = $authenticationManager;
        $this->rememberMeService = $rememberMeService;
        $this->guardHandler = $guardHandler;
    }

    public function login(Request $request)
    {
        $user = // retrieve user object

        if ($this->tokenStorage->getToken()) {
            $rememberMeToken = new RememberMeToken($user, 'main', ['ROLE_USER']);

            if (!$this->authenticationManager->supportsRememberMe()) {
                throw new RuntimeException('The security token is not supported');
            }

            try {
                $rememberMeAuth = $this->authenticationManager
                    ->createAuthenticator(AppCustomAuthenticator::class)
                    ->setToken($rememberMeToken);

                if ($rememberMeAuth instanceof RememberMeAuthenticationInterface && !$rememberMeAuth->isStateless()) {

                    // Set the remember me cookie

                    $this->rememberMeService
                        ->createRememberMeCookie(
                            new TokenBasedRememberMeServices($user, 'main', ['ROLE_USER'], null),
                            $request
                        );
                }

                // Authenticate the user

                return $this->guardHandler->authenticateUserAndHandleSuccess(
                    $rememberMeAuth,
                    $request,
                    $this->authenticationManager,
                    $this->tokenStorage
                );
            } catch (Exception $e) {
                // handle exception
            }
        }
    }
}