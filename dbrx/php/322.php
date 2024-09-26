use Symfony\Component\Security\Http\Event\InteractiveLoginEvent;
use Silex\Application;
use Silex\ServiceProviderInterface;

class SecurityServiceProvider implements ServiceProviderInterface {
    public function register(Application $app) {}

    public function boot(Application $app) {
        $dispatcher = $app['dispatcher'];
        $dispatcher->addListener('security.authentication.success', array($this, 'onSecurityAuthenticationSuccess'));
    }

    /**
     * @param InteractiveLoginEvent $event
     */
    public function onSecurityAuthenticationSuccess(InteractiveLoginEvent $event)
    {
        if ($targetPath = $event->getRequest()->get('_target_path')) {
            $session = $event->getRequest()->getSession();
            $session->set('_security.target_path', $targetPath);
        }
    }
}