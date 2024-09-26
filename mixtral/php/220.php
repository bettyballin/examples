public function edit($id)
{
    $userId = auth()->user()->id;

    if ($userId != $id && !auth()->user()->hasRole('admin')) {
        abort(403);
    }

    $user = User::find($id);
    return view('users.edit', compact('user'));
}