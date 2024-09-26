
$input = Input::all();
$input['password'] = Hash::make($input['password']); // Hashing the password
User::create($input);

return Redirect::to('/');

