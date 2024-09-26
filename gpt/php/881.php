
public function render($request, Exception $e)
{
    if ($e instanceof \Illuminate\Session\TokenMismatchException) {
        // Check if the user was trying to log out
        if ($request->getRequestUri() === '/logout') {
            // Here, you can safely assume the session is
