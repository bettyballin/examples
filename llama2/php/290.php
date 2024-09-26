// MyPhoneAuthenticationProvider.php

namespace App\Security;

use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authentication\Provider\AuthenticationProviderInterface;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\User\UserInterface;
use Doctrine\ORM\EntityManagerInterface;

class MyPhoneAuthenticationProvider implements AuthenticationProviderInterface
{
    private $entityManager;

    public function __construct(EntityManagerInterface $entityManager)
    {
        $this->entityManager = $entityManager;
    }

    public function authenticateToken(TokenInterface $token): ?TokenInterface
    {
        // Retrieve the user by the phone number(s) provided in the authentication request
        $user = $this->entityManager
            ->getRepository(User::class)
            ->findOneBy(['phone' => $token->getCredentials()]);

        if (!$user) {
            throw new AuthenticationException('User not found');
        }

        if (!$user instanceof UserInterface) {
            throw new AuthenticationException('User is not an instance of UserInterface');
        }

        return new UsernamePasswordToken($user, $user->getRoles());
    }

    public function supportsToken(TokenInterface $token): bool
    {
        return $token instanceof UsernamePasswordToken;
    }
}