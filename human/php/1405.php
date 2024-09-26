use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Response;

return new JsonResponse(
    ['status' => 'KO', 'message' => 'Unauthorized'],
    Response::HTTP_UNAUTHORIZED
);