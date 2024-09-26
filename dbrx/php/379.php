use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\HttpFoundation\RedirectResponse;

public function onAuthenticationSuccess(Request $request, TokenInterface $token, string $providerKey)
{
    if ($targetPath = $this->getTargetPath($request->getSession(), $providerKey)) {
        return new RedirectResponse($targetPath);
    }

    /** @var UserInterface $user */
    $user = $token->getUser();

    // Check user type and redirect accordingly
    switch (true) {
        case ($user instanceof Client):
            return new RedirectResponse('/client');

        case ($user instanceof Employe):
            return new RedirectResponse('/admin');
    }

    throw new \Exception('TODO: provide a valid redirect inside '.__FILE__);
}