class UserSubscriber implements EventSubscriber {
    private $mailService;

    public function __construct(MailService $mailService) {
        $this->mailService = $mailService;
    }

    public function postPersist(LifecycleEventArgs $args) {
        $entity = $args->getEntity();
        if ($entity instanceof User) { 
            $this->mailService->sendRegistrationMail($entity);
        }
    }

    // Removed setMailService method as it's no longer needed
}