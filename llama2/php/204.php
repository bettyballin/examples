namespace Tykayn\MeluzineBundle\Services;

use Symfony\Component\Security\Core\Encoder\BasePasswordEncoder;

class MyPasswordEncoder extends BasePasswordEncoder
{
    public function encodePassword($raw, $salt, $userData)
    {
        return sha1('blahblah' . $raw . 'blehbleh'. $salt. $userData['id']);
    } 

    public function isPasswordValid($encoded, $raw, $salt)
    {
        return $this->comparePasswords($encoded, $this->encodePassword($raw, $salt, array('id' => 1)));
    }
}

// Usage example
$encoder = new MyPasswordEncoder();
$rawPassword = 'mysecretpassword';
$salt = 'mysalt';
$userData = array('id' => 1);

$encodedPassword = $encoder->encodePassword($rawPassword, $salt, $userData);

var_dump($encodedPassword);

$isValid = $encoder->isPasswordValid($encodedPassword, $rawPassword, $salt);

var_dump($isValid);