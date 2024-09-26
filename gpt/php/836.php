
   namespace YourBundle\Listener;

   use Symfony\Component\HttpKernel\Event\GetResponseForExceptionEvent;
   use Symfony\Component\Security\Core\Exception\AccessDeniedException;
   use Symfony\Component\HttpFoundation\RedirectResponse;
   use Symfony\Component\Routing\RouterInterface;

   class AccessDeniedListener
   {
       private $router;

       public function __construct(RouterInterface $router)
       {
           $this->router = $router;
       }

       public function onKernelException(GetResponseForExceptionEvent $event)
       {
           // You get the exception object from the received event
           $exception = $event->getException();
           if ($exception instanceof AccessDeniedException) {
