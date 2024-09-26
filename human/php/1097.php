$key = '_security.user_firewall.target_path'; 

//check if the referrer session key has been set
if ($this->container->get('session')->has($key))
{
    //set the url based on the link they were trying to access before being authenticated
    $url = $this->container->get('session')->get($key);

    //remove the session key
    $this->container->get('session')->remove($key);
}
// if the referrer key was never set, redirect to a default route
else{
    $routeName = 'your_default_route_name'; // replace with your default route name
    $url = $this->generateUrl($routeName);
}

return new \Symfony\Component\HttpFoundation\RedirectResponse($url);