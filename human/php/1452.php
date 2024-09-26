use Symfony\Component\Routing\RouteCollection;
use Symfony\Component\Routing\Route;

$collection = new RouteCollection();

$collection->add('dev', new Route(
    '/(_(profiler|wdt)|css|images|js)/',
    array(),
    array(),
    array(),
    '',
    array(),
    array('GET', 'POST', 'PUT', 'DELETE'),
    '',
    array('security' => false)
));

return $collection;