
$user = new User;
$user->name = $data['name'];
$user->email = $data['email'];
$user->password = Hash::make($data['password']);
// ... set other properties as needed
$user->save();

// Now, you can mass assign the rest of the properties if needed:
$user->fill([
    'province' => $data['province'],
    'city' => $data['city'],
    'street' => $data['street'],
    'postal' => $data['postal'],
    'cellphone' => $data['cellphone'],
    // ... other fillable properties
]);
$user->save();

