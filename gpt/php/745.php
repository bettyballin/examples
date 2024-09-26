
class MailService
{
    // ...

    public function sendRegistrationMail(User $user, $body)
    {
        /** @var \Swift_Message $message */
        $message = $this->getMailer()->createMessage();

        $message->setSubject('You successful register in website')
            ->addTo($user->getEmail())
            ->setBody
