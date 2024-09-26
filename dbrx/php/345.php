namespace App\EventListener;

use Symfony\Component\HttpKernel\Event\RequestEvent;
use Psr\Log\LoggerInterface;
use Symfony\Component\HttpFoundation\Response;

class RequestSignatureListener
{
    private $logger;

    public function __construct(LoggerInterface $logger)
    {
        $this->logger = $logger;
    }

    public function onKernelRequest(RequestEvent $event): void
    {
        if (!$event->isMasterRequest()) {
            return; // Don't interfere with sub-requests.
        }

        $request = $event->getRequest();

        try {
            $calculatedSignature = $this->calculateSignature($request);
            
            if ($request->headers->get('signature') !== $calculatedSignature) {
                throw new \RuntimeException("Invalid request signature.");
            }
        } catch (\Exception $e) {
            // Log the error and return an appropriate response.
            $this->logger->error(sprintf(
                "Request validation failed: %s",
                $e->getMessage()
            ));

            if ($event->getRequest()->isXmlHttpRequest()) {
                throw new \RuntimeException("Invalid request signature.", 400);
            } else {
                // Redirect to a custom error page or return an HTTP response.
                $response = new Response();
                $response->setStatusCode(403); // Forbidden
                $event->setResponse($response);

                return;
            }
        }

    }

    private function calculateSignature(\Symfony\Component\HttpFoundation\Request $request): string
    {
        // Implement your signature calculation logic here e.g using hash_hmac().
        //
        // Example:
        // 
        // $data = json_encode([
        //     'header' => $request->headers->all(),
        //     'request' => $request->query->all() + $request->request->all()
        // ]);
        //
        // return hash_hmac('sha256', $data, 'your-secret-key');
    }
}