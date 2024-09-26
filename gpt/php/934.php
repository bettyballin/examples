
   use Symfony\Component\Routing\Annotation\Route;

   class SecurityController extends AbstractController
   {
       /**
        * @Route("/logout", name="logout")
        */
       public function logout()
       {
           // controller can be blank: it will never be executed!
           throw new \Exception('Don't forget to activate logout in security.yaml');
       }
   }
   
