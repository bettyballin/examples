if ($form->isValid() && !$this->getUser()) {
    $session = new Session();

    // Store the whole object
    $data = serialize($request->request);

    $session->set('my_key', $data);

    return $this->redirectToRoute('registration');
}