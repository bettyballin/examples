
$app->register(new Silex\Provider\SecurityServiceProvider(), array(
    'security.firewalls' => array(
        'secured' => array(
            'pattern' => '^/user/',
            'form' => array(
                'login_path' => '/connexion',
                'check_path' => '/user/login_check',
                'default_target_path' => '/user/homepage',
            ),
            'logout' => array('logout_path' => '/user/deconnexion'),
            // ... other options ...
        ),
        'default' => array(
            'anonymous' => true,
            'pattern' => '^.*$',
        ),
    ),
    // ... other security options ...
));

// Register the SecurityServiceProvider
$app->register(new Silex\Provider\SessionServiceProvider());

