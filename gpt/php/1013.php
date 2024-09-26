
// YourController.php or YourService.php

use Symfony\Component\Security\Http\Authentication\UserAuthenticatorInterface;
use Symfony\Component\Security\Http\RememberMe\RememberMeServicesInterface;

// Assuming $guardHandler, $formAuthenticator, and $rememberMeServices are already injected

public function authenticateUser(User $user, Request $request)
{
    $response = $guardHandler->authenticateUserAndHandleSuccess(
        $user,
        $request,
        $formAuthenticator,
        'main' // firewall name
    );

    // Manually trigger the remember me cookie
    $rememberMeServices->login
