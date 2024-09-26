namespace App\Security;

use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authorization\Voter\Voter;

class AdminVoter extends Voter
{
    const ADMIN_ATTRIBUTE = 'ADMIN';

    protected function supports($attribute, $subject)
    {
        if (!in_array($attribute, [self::ADMIN_ATTRIBUTE])) {
            return false;
        }

        // only vote on Admin objects inside this voter
        if (!$subject instanceof User || !$this->supportsClass(get_class($subject))){
            return false;
        }

        return true;
    }

    protected function voteOnAttribute($attribute, $subject, TokenInterface $token)
    {
        switch ($attribute) {

            case self::ADMIN_ATTRIBUTE:
                if (!$this->isAdminUser($subject)) {
                    // the user must have role ROLE_USER to access this route
                    return false;
                }

                break;
        }

        throw new \LogicException('This code should not be reached!');

        return true;
    }

    private function isAdminUser($user)
    {
       // your logic here

      if ($this->securityContext->isGranted(['ROLE_ADMIN'])){
          return true;
      }

      return false;
    }
}