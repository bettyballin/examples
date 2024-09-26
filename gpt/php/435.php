
// src/Acme/UserBundle/Handler/CustomLogoutSuccessHandler.php
namespace Acme\UserBundle\Handler;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\Security\Http\Logout\LogoutSuccessHandlerInterface;
use Symfony\Component\Security\Core\SecurityContextInterface;

class CustomLogoutSuccessHandler implements LogoutSuccessHandlerInterface
{
    private $securityContext;
    private $router;

    public function __construct(SecurityContextInterface $securityContext, $router)
    {
        $this->securityContext = $securityContext;
        $this->router = $router;
    }

    public function onLogoutSuccess(Request $request)
    {
        if ($this->securityContext->isGranted('ROLE_PREMIUM')) {
            $response = new RedirectResponse($this->
