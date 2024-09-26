public function updateAction(Request $request, $id) {
    // ...

    if ($form->isValid()) {
        $plainPassword = $form->get('password')->getData();

        if (!empty($plainPassword)) {
            // encode the password
            $encoder = $this->container->get('security.encoder_factory')
                ->getEncoder($user);

            $tempPassword = $encoder
                ->encodePassword(
                    $plainPassword,
                    $user->getSalt()
                );

            // set the encoded password
            $user->setPassword($tempPassword);
        }

        // persist and flush
        $em = $this->getDoctrine()->getManager();
        $em->persist($user);
        $em->flush();

        return $this->redirectToRoute('user_list');
    }

    return $this->render('user/edit.html.twig', [
        'form' => $form->createView(),
    ]);
}