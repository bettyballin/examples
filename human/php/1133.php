public function add(Request $request)
{
    if($this->securityContext->getToken() === null)
        return false;

    if(!$this->securityContext->getToken()->getUser() instanceof User)
        return false;

    if($this->securityContext->isGranted('IS_AUTHENTICATED_FULLY')) {
        // do stuff considering the user is logged in.
    }
}