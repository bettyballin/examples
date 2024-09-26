namespace App\EventSubscriber;

use Symfony\Component\HttpKernel\Event\ExceptionEvent;
use Symfony\Component\HttpKernel\EventListener\ExceptionListener as BaseExceptionListener;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\HttpFoundation\Response;

class AccessDeniedHandler extends BaseExceptionListener
{
    public static function getSubscribedEvents()
    {
        return [
            'kernel.exception' => ['onKernelException', 10],
        ];
    }

    protected function findTemplate(ExceptionEvent $event, \Throwable $exception)
    {
        if ($exception instanceof AccessDeniedException) {
            $response = new Response();
            $response->headers->set('Location', '/your-custom-template');
            return $response;
        }
        
        return parent::findTemplate($event, $exception);
    }
}