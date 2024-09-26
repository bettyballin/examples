class TokenListener
{
    protected $em;
    protected $token_storage;
    protected $templating;
    protected $router;
    protected $resolver;

    public function __construct($em, TokenStorageInterface $token_storage, TwigEngine $templating, Router $router, ControllerResolver $resolver)
    {
        $this->em = $em;
        $this->token_storage = $token_storage;
        $this->templating = $templating;
        $this->router = $router;
        $this->resolver = $resolver;
    }

    public function onKernelRequest(GetResponseEvent $event)
    {
        $request = $event->getRequest();
        $route  = $request->attributes->get('_route');
        $routeArr = array('fos_js_routing_js', 'fos_user_security_login', '_wdt'); //These are excluded routes. These are always allowed. Required for login page
        if(!is_int(array_search($route, $routeArr)) && false)
        {
            $userRoles = $this->token_storage->getToken()->getUser()->getRoles();
            if(!in_array('ROLE_NEWUSER', $userRoles))
            {
                $event->setResponse(new RedirectResponse($this->router->generate('user_management_unauthorized_user', array())));
            }
        }
    }
}