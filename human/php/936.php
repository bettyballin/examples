use Symfony\Component\Security\Core\Exception\AuthenticationException;

//You in controller
if (!$this->get('security.context')->isGranted('edit', $object)) {
    throw new AuthenticationException('Not a step furher chap!');
}