
// src/EventListener/AccessDeniedToNotFoundListener.php
namespace App\EventListener;

use Symfony\Component\HttpKernel\Event\ExceptionEvent;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpKernel\Exception\AccessDeniedHttpException;
use Symfony\Component\HttpKernel\Exception\NotFoundHttpException;

class AccessDeniedToNotFoundListener
{
    public function onKernelException(ExceptionEvent $event)
    {
        $exception = $event->getThrowable();

        // If the exception is an AccessDeniedHttpException, convert it to a NotFoundHttpException
        if ($exception instanceof AccessDeniedHttpException) {
            $event->setThrowable(new NotFoundHttpException('Not Found', $exception));
            
            // Optionally, you can also set the Response directly
            $response = new Response();
            $response->setContent('Not Found');
            $response->setStatusCode(Response::HTTP_NOT_FOUND);
            $event->setResponse
