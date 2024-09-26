Here is the executable PHP code:


namespace App\Security;

use Symfony\Component\Security\Core\User\UserCheckerInterface;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\Exception\UnsupportedUserException;
use Symfony\Component\Security\Core\Exception\DisabledException;

class MyUserChecker implements UserCheckerInterface
{
    public function checkPreAuth(UserInterface $user)
    {
        // Add your custom checks here if any.
        
        return;
    }

    public function checkPostAuth(UserInterface $user)
    {
        // Prevent logout after role change by not checking roles.

        /* Original implementation:
         * 
         * foreach ($this->getRoles($user) as $role) {
         *     if (!$user instanceof User && !in_array($role, self::SUPPORTED_ROLES)) {
         *         throw new UnsupportedUserException(sprintf('Instances of "%s" must have one of the following roles: "%s".', get_class($user), implode(', ', self::SUPPORTED_ROLES)));
         *     }
         *
         *     if (!$this->isGranted($role, $user)) {
         *         throw new DisabledException(sprintf('User account is disabled.', $user->getUsername()));
         *     }
         * }
         */
    }

    private function getRoles(UserInterface $user): array
    {
        // Add your custom logic to fetch roles from the user object.

        return [];
    }

    private function isGranted(string $role, UserInterface $user): bool
    {
        // Implement your own role checking mechanism here.
        
        return true;
    }
}