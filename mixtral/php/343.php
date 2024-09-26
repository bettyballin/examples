use App\Exception\InvalidSignatureException;
use Psr\Log\LoggerInterface;
use Symfony\Component\HttpKernel\Event\RequestEvent;
use Symfony\Component\HttpFoundation\Response;

class RequestSignatureValidator
{
    private $logger;

    public function __construct(LoggerInterface $logger)
    {
        $this->logger = $logger;
    }

    public function onKernelRequest(RequestEvent $event): void
    {
        if (!$event->isMainRequest()) {
            return;
        }

        try {
            $request = $event->getRequest();

            $signatureHeader = $request->headers->get('X-Signature');

            if (!$this->validateAndReproduce($request, $signatureHeader)) {
                throw new InvalidSignatureException();
            }
        } catch (InvalidSignatureException $e) {
            $this->logger->error($e->getMessage());
            $event->setResponse(new Response('Bad Request', Response::HTTP_BAD_REQUEST));
            return;
        }
    }

    private function validateAndReproduce($request, string $signatureHeader): bool
    {
        // Implement your signature validation and reproduction logic here
        // For example:
        // $expectedSignature = hash('sha256', $request->getContent());
        // return hash_equals($expectedSignature, $signatureHeader);
        return true; // Replace with actual logic
    }
}