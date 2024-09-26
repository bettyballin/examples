
// Security gate
if (Gate::allows('edit-litter', $litter)) {
    // The user is allowed to edit the litter
    return View::make('mykennel.litters.pupsheet')->with([
        //some variables
    ]);
} else {
    // The user is not allowed to edit the litter
    $ip_info = log_user_connection('Authorization Error');
    return View::make('errors.authorization')->with([
        'ip_info' => $ip_info,
        'litter_id' => $litter->id,
        'user_id' => Auth::user()->id,
        'litter_user' => $litter->user_id
    ]);
}

