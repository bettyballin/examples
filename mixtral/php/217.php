Here is the corrected code:


// src/AppBundle/Controller/SecureController.php

namespace AppBundle\Controller;

use Symfony\Component\HttpFoundation\BinaryFileResponse;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpKernel\Exception\NotFoundHttpException;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class SecureController extends Controller
{
    public function downloadAction($filename)
    {
        $filePath = $this->get('kernel')->getRootDir() . '/../web/uploads/secured/' . $filename;

        if (!is_readable($filePath)) {
            throw new NotFoundHttpException();
        }

        // Check user role
        if (!$this->getUser()) {
            return $this->redirectToRoute('login');
        }

        $response = new BinaryFileResponse($filePath);

        $response->setContentDisposition(Response::HEADER_CONTENT_DISPOSITION_ATTACHMENT, $filename);

        return $response;
    }
}