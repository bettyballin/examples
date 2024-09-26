namespace App\Security;

use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authorization\Voter\Voter;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;

class UserVoter extends Voter
{
    const DELETE = 'delete';

    protected function supports($attribute, $subject)
    {
        if (!in_array($attribute, array(self::DELETE))) return false;

        // only vote on User objects inside this voter
        if (!$subject instanceof User)
            return false;

        return true;
    }

    protected function voteOnAttribute($attribute, $user, TokenInterface $token)
    {
        switch ($attribute) {
            case self::DELETE:
                // check for ROLE_ADMIN
                if (!$this->decisionManager->decide($token, array('ROLE_ADMIN')))
                    return false;

                foreach ($user->getRoles() as $role){
                    if (in_array(strtoupper($role), ['ROLE_SUPER_ADMIN', 'ROLE_ADMIN']))
                        // You can not delete this user!
                        throw new AccessDeniedException('Cannot delete this user!');
                }

                return true;

            default:
                return false;
        }
    }
}