
namespace Tykayn\MeluzineBundle\Services;

use Symfony\Component\Security\Core\Encoder\PasswordEncoderInterface;

class MyPasswordEncoder implements PasswordEncoderInterface
{
    public function encodePassword($raw, $salt)
    {
        // Your custom logic here
    } 

    public function isPasswordValid($encoded, $raw, $salt)
    {
        return $encoded === $this->encodePassword($raw, $salt);
    }
}

