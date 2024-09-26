use Symfony\Component\HttpKernel\Event\GetResponseForExceptionEvent;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\HttpKernel\Exception\AccessDeniedHttpException;

public function onKernelException(GetResponseForExceptionEvent $event)
{
    $exception = $event->getException();

    if ($exception instanceof AccessDeniedHttpException) {
        $event->setResponse(new RedirectResponse('/'));
    }
}