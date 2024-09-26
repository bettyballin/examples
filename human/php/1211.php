Not a PHP code, but Symfony configuration. However, here is how you can define it in PHP:


$container->loadFromExtension('security', array(
    'firewalls' => array(
        'my_firewall' => array(
            // ...
            'access_denied_handler' => 'my_access_denied_handler_service',
            // ...
        ),
    ),
));