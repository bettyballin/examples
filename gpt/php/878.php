
use Silex\Application;
use Silex\Provider\SecurityServiceProvider;
use Symfony\Component\Security\Core\Encoder\PlaintextPasswordEncoder;
use Symfony\Component\Security\Core\User\User;

require_once __DIR__.'/../vendor/autoload.php';

$app = new Application();

$app->register(new SecurityServiceProvider(), [
    'security.firewalls' => [
        'admin' => [
            'pattern' => '^/admin',
            'http' => true,
            'users' => function () use ($app) {
                // Define your user(s) here
                $users = [
                    'admin' => ['password' => 'admin', 'roles' => ['ROLE_ADMIN']],
                    // ... other users
                ];

                $userProvider = new InMemoryUserProvider();

                foreach ($users as $username => $details) {
                   
