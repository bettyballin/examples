public function showAction($id)
{
    // get a Post instance
    $post = $this->getDoctrine()->getRepository(Post::class)->find($id);

    // keep in mind that this will call all registered security voters
    $this->denyAccessUnlessGranted('view', $post, 'Unauthorized access!');

    return new Response('<h1>'.$post->getName().'</h1>');
}