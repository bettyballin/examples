$post = Request::createFromGlobals();
if($post->request->has('change') && !$user->hasRole('ROLE_MEDIA')){
    $em = $this->getDoctrine()->getManager();
    $user->setRoles(array('ROLE_MEDIA'));
    $em->flush();
    $this->get('session')->migrate();
}