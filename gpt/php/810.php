
if ($form->isSubmitted() && $form->isValid()) {
    if (!$this->getUser()) {
        // Store form data in the session
        $this->get('session')->set('form_data', $form->getData());

        // Redirect to the registration or login page
        return $this->redirectToRoute('registration_route');
    } else {
        // Save form data as the user is authenticated
        // ...
    }
}

