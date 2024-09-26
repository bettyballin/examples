<?php

use Symfony\Component\EventDispatcher\EventSubscriberInterface;
use Acme\UserEvent;
use Acme\MailService;

class UserRegistrationMailSubscriber implements EventSubscriberInterface
{
    /**
     * @var MailService
     */
    private $mailService;

    public function __construct(MailService $mailService)
    {
        $this->mailService = $mailService;
    }

    /**
     * {@inheritdoc}
     */
    public static function getSubscribedEvents()
    {
        return array(
            'acme.user.registered'  => 'sendRegistrationMail',
        );
    }

    /**
     * @param UserEvent $event
     */
    public function sendRegistrationMail(UserEvent $event)
    {
        $this->mailService->sendRegistrationMail($event->getUser());
    }
}