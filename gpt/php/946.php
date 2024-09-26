
// src/EventListener/RequestSignatureListener.php

namespace App\EventListener;

use Symfony\Component\HttpKernel\Event\RequestEvent;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpKernel\Exception\HttpException;

class RequestSignatureListener
{
    public function onKernelRequest(RequestEvent $event)
    {
        $request = $event->getRequest();

        // Assuming your request payload is JSON
        $content = $request->getContent();
        $data = json_decode($content, true);

        if (isset($data['header']['signature'])) {
            $signature = $data['header']['signature'];
            // Regenerate the signature based on the request data
            $expectedSignature = $this->generateSignature($data['request']);

           
