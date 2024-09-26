
public function onKernelResponse(FilterResponseEvent $event) {
    $request = $event->getRequest();
    $tokenStorage = $this->container->get('security.token_storage');

    // Check if a token exists and if a user is fully authenticated
    $token = $tokenStorage->getToken();
    if ($token && $this->container->get('security.authorization_checker')->isGranted('IS_AUTHENTICATED_FULLY')) {
        // Check if the cookie doesn't exist
        if (!$request->cookies->has(DeviceManager::COOKIE_PREFIX.'id')) {
            // Create the cookie
            $DeviceManager = $this->container->get('salus_user.device_manager');
            $Cookie = $DeviceManager->createDeviceCookie();
