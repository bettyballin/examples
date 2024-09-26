
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\SecurityContextInterface;

public function alternateloginAction($username, $password)
{
    $userProvider = $this->get('your_user_provider_service');
    $tokenStorage = $this->get('security.token_storage');
    $authenticationManager = $this->get('security.authentication.manager');

    try {
        $user = $userProvider->loadUserByUsername($username);

        $token = new UsernamePasswordToken($user, $password, 'your_firewall_name', $user->getRoles());

       
