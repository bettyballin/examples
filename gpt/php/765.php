
public function edit(User $user)
{
    if ($user->id != auth()->id()) {
        // Abort with a 403 error if the user is not authorized
        abort(403, 'Unauthorized action.');
    }

    // Proceed with the edit operation for the authenticated user
    // ...
}

