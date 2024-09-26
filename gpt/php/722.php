
public function logoutAction(Request $request)
{
    // Get the session from the request
    $session = $request->getSession();

    // Invalidate the session
    $session->invalidate();

    // Get the "remember me" service
    $rememberMeService = $this->get('security.rememberme.services.persistent');
    // Or if you are using the simple hash-based remember me service:
    // $rememberMeService = $this->get('security.rememberme.services.simplehash');

    // Manually logging out the user
    $this->get('security.token_storage')->setToken(null);

    // Clear the remember me cookie
    $response = new Response();
    $rememberMeService->loginFail($request, $response);

   
