use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/logout", name="project_frontend_main_logout")
 */
public function logout(): void
{
    // controller can be blank: it will never be executed!
    throw new \Exception('This should never be reached!');
}