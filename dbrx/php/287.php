namespace AppBundle\Event;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpKernel\Event\GetResponseForExceptionEvent;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\HttpKernel\EventListener\ExceptionListener as BaseExceptionListener;

class AccessDeniedListener extends BaseExceptionListener
{
    protected function handleException(GetResponseForExceptionEvent $event, \Throwable $exception)
    {
        if ($exception instanceof AccessDeniedException) {
            $response = new Response();
            $response->setStatusCode(Response::HTTP_NOT_FOUND);

            $event->allowCustomResponseCode();
            $event->setResponse($response);
        } else {
            parent::handleException($event, $exception);
        }
    }
}