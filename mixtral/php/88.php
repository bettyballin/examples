namespace AppBundle\DependencyInjection\Compiler;

use Symfony\Component\DependencyInjection\ContainerBuilder;
use Symfony\Component\DependencyInjection\Compiler\CompilerPassInterface;

class AccessControlPass implements CompilerPassInterface
{
    public function process(ContainerBuilder $container)
    {
        if (!$container->hasDefinition('security.firewall')) {
            return;
        }

        // Get the firewalls
        $firewalls = $container
            ->getParameterBag()
            ->resolveValue($container
                ->getDefinition('security.firewall')
                ->getArgument(0)
            );

        foreach ($firewalls as &$config) {
            if (!isset($config['access_control'])) continue;

            // Extract access control rules
            $rules = [];

            foreach ((array)$config['access_control'] as $rule)
                $rules[] = [
                    'path' => isset($rule[0]) ? (string)$rule[0] : null,
                    'allowIf' => array_key_exists(1, $rule) ? $rule[1] : null,
                    // ...
                ];

            if (!empty($config['access_control'])) {
                $container->setParameter('security.firewall.' . key($firewalls) . '.access_control', $rules);
            }
        }
    }
}