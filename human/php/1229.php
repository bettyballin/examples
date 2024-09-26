namespace AppBundle\EventListener;

use AppBundle\Configuration\SecurityConfiguration;
use Symfony\Component\HttpKernel\Event\FilterControllerEvent;
use Symfony\Component\HttpKernel\KernelEvents;

class SecurityListener extends \Sensio\Bundle\FrameworkExtraBundle\EventListener\SecurityListener
{
    public function onKernelController(FilterControllerEvent $event)
    {
        $request = $event->getRequest();
        if (!$configuration = $request->attributes->get('_app_security')) {
            return;
        }

        // trick to simulate one security configuration (all in one class/method).
        $request->attributes->set('_security', new SecurityConfiguration($configuration));

        parent::onKernelController($event);
    }

    public static function getSubscribedEvents()
    {
        // this listener must be called after Sensio\Bundle\FrameworkExtraBundle\EventListener\ControllerListener.
        return array(KernelEvents::CONTROLLER => array('onKernelController', -1));
    }
}