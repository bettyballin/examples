// src/AppBundle/Controller/ExceptionController.php

namespace AppBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpKernel\Exception\AccessDeniedHttpException;
use Symfony\Component\HttpKernel\Exception\FlattenException;

class ExceptionController extends \Symfony\Bundle\TwigBundle\Controller\ExceptionController
{
    public function showAction(Request $request, FlattenException $exception)
    {
        if ($this->isAllowed($exception)) {
            return parent::showAction($request, $exception);
        }

        // Customize the response for AccessDeniedHttpExceptions
        if ($exception instanceof AccessDeniedHttpException) {

            return new Response($this->twig->render('@App/error_pages/access-denied.html.twig'));
        }

        // For other exceptions use the default behavior
        return parent::showAction($request, $exception);
    }

    private function isAllowed(FlattenException $exception)
    {
        return false;
    }
}