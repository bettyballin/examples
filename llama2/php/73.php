// src/MyUserBundle/Security/LoginHandler.php

namespace MyUserBundle\Security;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;
use Symfony\Component\Security\Core\AuthenticationManager;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\User\UserProviderInterface;

class LoginHandler implements LoginHandlerInterface
{
    private $authenticationManager;
    private $userProvider;

    public function __construct(AuthenticationManager $authenticationManager, UserProviderInterface $userProvider)
    {
        $this->authenticationManager = $authenticationManager;
        $this->userProvider = $userProvider;
    }

    public function handleLoginRequest(Request $request)
    {
        $username = $request->get('_username');
        $password = $request->get('_password');

        try {
            $token = new UsernamePasswordToken($username, $password, 'main');
            $authToken = $this->authenticationManager->authenticate($token);

            // ...
        } catch (AuthenticationException $e) {
            // ...
        }
    }
}