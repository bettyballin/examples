public function acceptPR(Request $request, AuthorizationCheckerInterface $authChecker)
{
    // ...

    if (!$authChecker->isGranted('ACCEPT_PR', $pr)) {
        throw new AccessDeniedException();
    }

    $workflow = $this->getWorkflow($pr);

    try {
       $workflow->apply($pr, 'accept');

       // ...

    } catch (TransitionNotAllowedException $e) {}
}