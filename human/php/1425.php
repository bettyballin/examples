use Symfony\Component\Config\Definition\Builder\ArrayNodeDefinition;

$container->loadFromExtension('security', [
    'firewalls' => [
        // ... other firewall entries ...
        'api' => [
            'pattern' => '^/api',
            'stateless' => true,
            'anonymous' => true,
            'provider' => 'all_users',
            'guard' => [
                'authenticators' => [
                    'lexik_jwt_authentication.security.guard.jwt_token_authenticator',
                ],
            ],
        ],
    ],
]);