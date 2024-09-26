
public function handle($request, Closure $next)
{
    $user = auth()->user();

    if ($user && $request->session()->getId() != $user->session_id) {
        auth()->logout(); // log out user if session IDs do not match
        return redirect('/login')->withErrors(['Your account is logged in from another device.']);
    }

    return $next($request);
}

