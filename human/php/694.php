This is not PHP code, it appears to be a YAML configuration file, likely for a Symfony application. However, I'll provide the equivalent PHP code for the given YAML configuration:


use Symfony\Component\Config\Definition\Builder\TreeBuilder;

$config = new TreeBuilder('firewalls');
$rootNode = $config->getRootNode();

$rootNode
    ->children()
        ->arrayNode('main')
            ->children()
                ->arrayNode('form_login')
                    ->children()
                        ->scalarNode('failure_handler')->defaultValue('mybundle.security.handler.failure')->end()
                        ->scalarNode('success_handler')->defaultValue('mybundle.security.handler.success')->end()
                    ->end()
                ->end()
                ->arrayNode('logout')
                    ->children()
                        ->scalarNode('success_handler')->defaultValue('mybundle.security.handler.logout')->end()
                    ->end()
                ->end()
            ->end()
        ->end()
    ->end()
;