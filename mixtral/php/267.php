namespace App\Service;

use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;

class PasswordHistoryChecker
{
    private $passwordEncoder;

    public function __construct(UserPasswordEncoderInterface $encoder)
    {
        $this->passwordEncoder = $encoder;
    }

    /**
     * @param string[] $oldHashedPasswords
     */
    public function isNewPasswordValid(string $newRawPassword, array $oldHashedPasswords): bool
    {
        foreach ($oldHashedPasswords as $hashedOldPassword) {
            if (password_verify($newRawPassword, $hashedOldPassword)) {
                return false;
            }
        }

        // If no match found
        return true;
    }
}