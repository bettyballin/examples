$activeSessions = DB::table('sessions')
    ->where('user_id', $userId)
    ->where('session_id', '!=', Session::getId())
    ->get();

if ($activeSessions->isNotEmpty()) {
    Auth::logout();
    return redirect()->route('login')->withErrors(['error' => 'You have been logged out because your account is already active on another device.']);
}