use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Support\Facades\Auth;

public function register(Request $request)
{
    // Validate the request...

    if ($referrer = User::where('username', $request->input('refer'))->first()) {
        Auth::login($referrer);
    }

    return redirect('/dashboard');
}