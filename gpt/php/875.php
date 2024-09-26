
abstract class SecureController extends Controller
{
    protected function checkBasePermission()
    {
        $this->denyAccessUnlessGranted('my_permission');
    }
}

class MyController extends SecureController
{
   
