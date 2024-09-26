This is not PHP code, but rather a YAML configuration file for Symfony. However, I'll provide the equivalent PHP code for this configuration:


use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Http\FirewallMapInterface;
use Symfony\Component\Security\Http\FirewallMap;

$container->setParameter('security.firewalls', array(
    'other_secured_area' => array(
        'host' => '^localhost$',
        'pattern' => '^/usermanagement',
    ),
));

$firewallMap = new FirewallMap();

$request = Request::createFromGlobals();
$firewallMap->add($request->getHost(), array('other_secured_area'));

// Assuming you have the firewall factory and the token storage
$firewall = $container->get('security.firewall.factory')->create($firewallMap, 'other_secured_area');
$tokenStorage = $container->get('security.token_storage');

$firewall->handleRequest($request);