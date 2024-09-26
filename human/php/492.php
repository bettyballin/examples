use Symfony\Component\HttpFoundation\Response;

public function fileUploadAction(){
    //control if user is logged and has required role as usual with Symfony2
    $this->denyAccessUnlessGranted('ROLE_REQUIRED');

    $uploader = new \Path\To\FileUpload();
    //do something with object uploader

    return new Response('', 200);
}