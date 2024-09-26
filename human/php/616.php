public function updateAction(Request $request, $id) {
    $em = $this->getDoctrine()->getManager();
    $user = $em->getRepository('ManaClientBundle:User')->find($id);

    $form = $this->createForm(new UserEditType(), $user);
    $form->handleRequest($request);
    if ($form->isSubmitted() && $form->isValid()) {
        $em->persist($user);
        $em->flush();
        return $this->redirectToRoute('user_main');
    }
    return $this->render('ManaClientBundle:User:edit.html.twig', array(
        'form' => $form->createView(),
        'user' => $user,
        'title' => 'Edit user',
    ));
}