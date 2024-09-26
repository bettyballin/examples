
   use Illuminate\Support\Facades\Storage;
   use Illuminate\Support\Facades\Response;
   use Illuminate\Http\Request;

   class VideoController extends Controller
   {
       public function show($filename)
       {
           // Ensure the user is authenticated
           $this->middleware('auth');

           // Check if file exists
           if (!
