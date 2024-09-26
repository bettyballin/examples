use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;
use Symfony\Component\Security\Core\User\UserInterface;

// ...

public function changeRoleAction(Request $request, TokenStorageInterface $tokenStorage)
{
    // Your existing code...

    if ($request->request->has('change') && !$user->hasRole('ROLE_MEDIA')) {
        $em = $this->getDoctrine()->getManager();

        $roles = array('ROLE_USER', 'ROLE_MEDIA'); // Assuming ROLE_USER is the default role

        if ($tokenStorage->getToken()) {
            /** @var UserInterface */
            $currentUser = $this->getUser();

            $userRoles = array_map(function($role) {
                return 'ROLE_' . strtoupper($role);
            }, $roles);

            // Update the roles in token
            $tokenStorage->getToken()->setUser($currentUser);

            /** @var UsernamePasswordToken */
            $newToken = new UsernamePasswordToken(
                $currentUser,
                null,
                'main',
                array_combine($roles, $roles)
            );

            // Replace the token in storage
            $tokenStorage->setToken($newToken);
        }

        $em->flush();
    }
}