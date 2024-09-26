public function add(Request $request)
{
    if($this->securityContext->isGranted('IS_AUTHENTICATED_FULLY')) {
        /* do stuff considering the user is logged in.
        ** This is wrong ; we can end up here while having a logged out user.
        */
    } else {
        throw new AccessDeniedException('You must be logged in to access this page.');
    }
}