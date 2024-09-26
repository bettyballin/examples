
protected function authenticated(Request $request, $user)
{
    // Invalidate previous sessions for the user
    \DB::table('sessions')
        ->where('user_id', $user->id)
        ->delete();

    // Associate the new session with the user
    session(['user_id' => $user->id]);
