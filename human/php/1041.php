public function onKernelResponse(FilterResponseEvent $event) {
    if (!$this->container->get('security.token_storage')->getToken()) {
        return;
    }
    // Rest of code.
}