public function showRecording($id)
{
    // Fetch recording from DB using $id
    $fetched_recording = Recording::find($id);

    // Get current authenticated user
    $user = Auth::user();

    // Check if this fetched record is assigned to the currently logged-in user by querying their designations table with both the user's ID and retrieved Recording ID.
    $designation = DesignationTable::where('User_id', $user->id)
                                   ->where('Recording_id', $fetched_recording->id)->first();

    // If designation exists then display recording
    if ($designation) {
        return view('recording.show')->with(compact('fetched_recording'));
    } else {
        abort(403);  // Unauthorized access - user is not assigned to this record.
    }
}