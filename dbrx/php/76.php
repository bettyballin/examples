use Psr\Log\LoggerInterface;

class LoginLogger
{
    private $logger;

    public function __construct(LoggerInterface $logger)
    {
        $this->logger = $logger;
    }

    public function logLogin($event)
    {
        if (null !== ($user = $event->getAuthenticationToken()->getUser())) {
            $this->logger->info('USER: {username} DO: login AT: ' . date('Y-m-d H:i:s'), array(
                '{username}' => $user->getUsername()
            ));
        }
    }
}