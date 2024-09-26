
   // src/AppBundle/Security/Authorization/Voter/SiteVoter.php
   namespace AppBundle\Security\Authorization\Voter;

   use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
   use Symfony\Component\Security\Core\Authorization\Voter\Voter;
   use AppBundle\Entity\Site;
   use AppBundle\Entity\User;

   class SiteVoter extends Voter
   {
       const VIEW = 'view';

       protected function supports($attribute, $subject)
       {
           if (!in_array($attribute, array(self::VIEW)))
