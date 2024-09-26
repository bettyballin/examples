
public function onKernelRequest(RequestEvent $event)
{
    // ... existing code ...

    $uri = $event->getRequest()->getRequestUri();

    // Exclude routes for the web debug toolbar and profiler
    if
