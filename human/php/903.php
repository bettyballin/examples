<?php

use Symfony\Component\Config\Definition\Builder\TreeBuilder;
use Symfony\Component\Config\Definition\ConfigurationInterface;

class SecurityConfig implements ConfigurationInterface
{
    public function getConfigTreeBuilder()
    {
        $treeBuilder = new TreeBuilder('security');
        $rootNode = $treeBuilder->getRootNode();

        $rootNode
            ->children()
                ->arrayNode('security_providers')
                    ->children()
                        ->arrayNode('user_db')
                            ->children()
                                ->arrayNode('entity')
                                    ->children()
                                        ->scalarNode('class')->defaultValue('Acme\AcmeBundle\Entity\User')->end()
                                        ->scalarNode('property')->defaultValue('id')->end()
                                    ->end()
                                ->end()
                            ->end()
                        ->end()
                    ->end()
                ->end()
                ->arrayNode('security_firewalls_user_management')
                    ->children()
                        ->scalarNode('pattern')->defaultValue('^/')->end()
                        ->scalarNode('anonymous')->defaultValue('~')->end()
                        ->scalarNode('form_login')->defaultValue('~')->end()
                        ->scalarNode('logout')->defaultValue('~')->end()
                        ->booleanNode('switch_user')->defaultValue(true)->end()
                    ->end()
                ->end()
                ->scalarNode('login_controller')->defaultValue('AcmeDevBundle:Security:login')->end()
            ->end()
        ;

        return $treeBuilder;
    }
}