$inputCode = $request->code;

// Fetch all codes
$codes = Stuff::all();

foreach ($codes as $storedCode) {
    if (Hash::check($inputCode, $storedCode['code'])){
        // Code is valid

        break;
     }
}