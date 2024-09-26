namespace App\EventSubscriber;

use Doctrine\Common\Annotations\AnnotationReader;
use Symfony\Component\HttpKernel\Event\ControllerEvent;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;
use ReflectionObject;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;

class IsActiveListener
{
    private $tokenStorage;

    public function __construct(TokenStorageInterface $tokenStorage)
    {
        $this->tokenStorage = $tokenStorage;
    }

    public function onKernelController(ControllerEvent $event)
    {
        if (!is_array($controller = $event->getController())) {
            return;
        }

        [$controller, $method] = $controller;

        $reader = new AnnotationReader();

        $classAnnotations = $reader->getClassAnnotations(new ReflectionObject($controller));
        $methodAnnotations = $reader->getMethodAnnotations(new ReflectionMethod($controller, $method));

        foreach (array_merge($classAnnotations, $methodAnnotations) as $annotation) {
            if ($annotation instanceof Security && !$this->getUser()->getIsActive()) {
                throw new AccessDeniedException('Access denied. User is not active.');
            }
        }
    }

    private function getUser()
    {
        return $this->tokenStorage->getToken()->getUser();
    }
}