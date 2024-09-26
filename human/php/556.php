$securityContext = $this->get('security.context');
$comment = $this->getDoctrine()->getRepository('AppBundle\Entity\Comment')->find($id);

if (false === $securityContext->isGranted('EDIT', $comment))
{
    throw new \Symfony\Component\Security\Core\Exception\AccessDeniedException();
}