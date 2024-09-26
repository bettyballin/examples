use Symfony\Component\Security\Core\Authorization\Voter\RoleVoter;
use Symfony\Component\Security\Core\Authorization\AccessDecisionManager;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;

$accessDecisionManager = new AccessDecisionManager(array(
    new RoleVoter(),
));

$token = new class implements TokenInterface {
    public function getCredentials()
    {
        // credentials
    }

    public function getUser()
    {
        // user
    }

    public function getRoleNames()
    {
        return array('IS_AUTHENTICATED_ANONYMOUSLY');
    }

    public function getAttributes()
    {
        // attributes
    }

    public function hasAttribute($attribute)
    {
        // has attribute
    }

    public function isAuthenticated()
    {
        return true;
    }

    public function setAuthenticated($authenticated)
    {
        // set authenticated
    }

    public function eraseCredentials()
    {
        // erase credentials
    }

    public function getFirewallName()
    {
        // firewall name
    }

    public function setFirewallName($firewallName)
    {
        // set firewall name
    }

    public function getAttributesByReference()
    {
        // attributes by reference
    }

    public function getAttribute($attribute)
    {
        // attribute
    }
};

$accessDecisionManager->decide($token, array('IS_AUTHENTICATED_ANONYMOUSLY'));