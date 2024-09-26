// app/Models/Recording.php

public function resolveRouteBinding($value, $field = null)
{
    // Get the current user and requested recording
    $user = auth()->user();

    if (!$this->where([
        'RecordID' => (int)$value,
        'User_id'  => $user->id
    ])->exists()) {

        abort(403);

    }

    return parent::resolveRouteBinding($value, $field);
}