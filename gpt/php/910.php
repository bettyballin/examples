
use Silex\Application;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

$app->register(new Silex\Provider\SecurityServiceProvider(), array(
    'security.firewalls' => array(
        'secured' => array(
            'pattern' => '^/',
            'anonymous' => true,
            'form' => array(
                'login_path' => '/login',
                'check_path' => '/secured/login_check',
                'default_target_path' => '/',  // You can change this to your desired path
                'use_forward' => false,
            ),
            'logout' => array('logout_path' => '/secured/logout', 'invalidate_session' => true),
            'users' => $users,
        ),
    ),
    'security.access_rules' => array(
        array('^/admin', 'ROLE_ADMIN'),
