if ($user = User::where('email', $request->input('email'))->first()) {
    // Check the current session id with stored one.
    if (Session::getHandler()->read($user->session_id)) {
        return redirect('/login')->withErrors(['You are already logged in.']);
    }
}