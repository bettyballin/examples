namespace Tykayn\MeLuZineBundle\Services;

use Symfony\Component\Security\Core\User\AdvancedUserInterface;
use Symfony\Component\Security\Core\Encoder\BasePasswordEncoder;

class MyPasswordEncoder extends BasePasswordEncoder
{
    private $userObject = null;

    public function setMyUserObject(AdvancedUserInterface $myUserObject)
    {
        $this->userObject = $myUserObject;

        return $this;
    }

    public function encodePassword($raw, $salt)
    {
        if ($this->userObject === null || !$this->userObject instanceof AdvancedUserInterface)
            throw new \RuntimeException('My User Object is not set.');

        return sha1(
            'blahblah' .
            $raw .
            'blehbleh'.
            $salt.
            $this->userObject->getId()
        );
    }
}