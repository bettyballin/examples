use App\Repository\UserRepository;
use Symfony\Component\HttpFoundation\Response;

/**
 * @IsActive
 */
public function index(UserRepository $userRepo): Response
{
    $users = $userRepo->findAll();
    return new Response(json_encode($users));
}