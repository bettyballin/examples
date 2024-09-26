
    $isPasswordCorrect = password_verify($enteredPassword, $storedPasswordHash);
    if ($isPasswordCorrect) {
