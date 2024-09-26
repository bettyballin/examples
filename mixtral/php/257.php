// src/AppBundle/Controller/SecurityController

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;
use AppBundle\Handler\AuthenticationSuccessHandler;

class SecurityController extends Controller
{
    public function alternateLoginAction($username, $password)
    {
        // Create a token
        $token = new UsernamePasswordToken(
            $username,
            null,
            'main',
            array('ROLE_USER')
        );

        // Set the user
        $userProvider = $this->get('fos_user.user_provider');

        try {
            $user = $userProvider->loadUserByUsername($username);

            if ($password !== null) {
                // Authenticate the user
                $encoder = $this->get('security.encoder_factory')->getEncoder($user);
                $isValid = $encoder->isPasswordValid($user, $password);

                if ($isValid) {
                    // Set the token
                    $this->get('security.context')->setToken($token);
                    // Dispatch the login event
                    $this->get('event_dispatcher')->dispatch('security.interactive_login', new InteractiveLoginEvent($request, $token));
                    // Redirect to the target URL
                    return $this->redirect($this->generateUrl('home'));
                }
            }
        } catch (\Exception $e) {
            throw new \RuntimeException('Username not found');
        }
    }
}