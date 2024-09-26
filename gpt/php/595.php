
namespace AppBundle\DependencyInjection\Compiler;

use Symfony\Component\DependencyInjection\Compiler\CompilerPassInterface;
use Symfony\Component\DependencyInjection\ContainerBuilder;

class AccessControlCompilerPass implements CompilerPassInterface
{
    public function process(ContainerBuilder $container)
    {
        // The 'security.access_map' service holds the access control rules
        $accessMapDefinition = $container->getDefinition('security.access_map');
        $accessControl = $accessMapDefinition->getArgument(0);

        // Now you can set this as a parameter or pass it directly to your services
