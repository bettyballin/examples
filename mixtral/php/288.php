namespace App\EventListener;

use Symfony\Component\HttpKernel\Event\ExceptionEvent;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\HttpKernel\Exception\NotFoundHttpException;

class AccessDeniedToNotFoundListener
{
    public function onKernelException(ExceptionEvent $event)
    {
        // Get the thrown exception
        $exception = $event->getThrowable();

        if ($exception instanceof AccessDeniedException)
        {
            // Create a new NotFoundHttpException
            $notFoundException = new NotFoundHttpException($exception->getMessage(), $exception);

            // Replace the exception in the event with our custom one
            $event->setThrowable($notFoundException);
        }
    }
}