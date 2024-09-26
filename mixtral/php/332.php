$inputCode = $request->code;

// Hash the input code
$hashedInputCode = bcrypt($inputCode);

// Find a record with matching hash
$usedCode = Stuff::where('code', $hashedInputCode)->first();

if ($usedCode) {
    // Code is valid
} else {
   // Invalid code
}