use Symfony\Component\Config\Definition\Builder\TreeBuilder;
use Symfony\Component\Config\Definition\ConfigurationInterface;

class SecurityConfiguration implements ConfigurationInterface
{
    public function getConfigTreeBuilder()
    {
        $treeBuilder = new TreeBuilder('security');
        $rootNode = $treeBuilder->getRootNode();

        $rootNode
            ->children()
                ->arrayNode('security_providers')
                    ->children()
                        ->arrayNode('user_auth')
                            ->children()
                                ->arrayNode('entity')
                                    ->children()
                                        ->scalarNode('class')->defaultValue('Acme\AcmeBundle\Entity\User')->end()
                                        ->scalarNode('property')->defaultValue('other_id')->end()
                                    ->end()
                                ->end()
                            ->end()
                        ->end()
                    ->end()
                ->end()
                ->arrayNode('security_firewalls_user_management')
                    ->children()
                        ->scalarNode('pattern')->defaultValue('^/')->end()
                        ->booleanNode('anonymous')->defaultValue(true)->end()
                        ->arrayNode('trusted_sso')
                            ->children()
                                ->scalarNode('manager')->defaultValue('user_sso')->end()
                                ->booleanNode('login_action')->defaultValue(false)->end()
                                ->booleanNode('logout_action')->defaultValue(false)->end()
                                ->scalarNode('check_path')->defaultValue('/')->end()
                                ->scalarNode('login_path')->defaultValue('page_login')->end()
                            ->end()
                        ->end()
                        ->booleanNode('logout')->defaultValue(true)->end()
                        ->booleanNode('switch_user')->defaultValue(true)->end()
                    ->end()
                ->end()
                ->scalarNode('login_controller')->defaultValue('AcmeBundle:Main:login')->end()
            ->end()
        ;

        return $treeBuilder;
    }
}