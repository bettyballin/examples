public function userManagement(Request $request)
{
    if ($request->getHost() !== 'localhost') {
        throw $this->createAccessDeniedException();
    }
}