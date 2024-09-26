namespace Sdz\UserBundle\Security\Encoder;

use Symfony\Component\Security\Core\Encoder\BasePasswordEncoder;

class CustomEncoder extends BasePasswordEncoder
{
    public function encodePassword($raw, $salt)
    {
        // do doctrine stuff to get the user info
        $hashed = // your hashing logic here;
        return $hashed;
    }

    public function isPasswordValid($encoded, $raw, $salt)
    {
        return $this->comparePasswords($encoded, $this->encodePassword($raw, $salt));
    }
}