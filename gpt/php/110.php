
$entryId = 1; // Replace with the actual entry ID.
$spinner = generateSpinner($entryId);

// Generate hashed field names.
$usernameFieldName = hashFieldName('username', $spinner);
$passwordFieldName = hashFieldName('password', $spinner);

