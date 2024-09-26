namespace App\Security;

use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authorization\Voter\Voter;

class UserEnabledVoter extends Voter
{
    protected function supports($attribute, $subject)
    {
        return 'USER_ENABLED' === $attribute && in_array('ROLE_USER', $this->getUser()->getRoles());
    }

    protected function voteOnAttribute($attribute, $subject, TokenInterface $token)
    {
        // Check user is enabled or not.
        if (false === $this->getUser()->isEnabled()) {
            return false;
        }
        
        return true;
    }
}