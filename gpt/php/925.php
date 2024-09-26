
$code = 'your_secret_code';
$hashedCode = Hash::make($code);

// Then store $hashedCode in your database instead of the plain text code
$stuff = new Stuff;
$stuff->code = $hashedCode;
$stuff->save();

