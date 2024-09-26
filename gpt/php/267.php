
$securityCode = "1234567";
$securityCodeLength = strlen($securityCode);
$randomPosition = rand(0, $securityCodeLength - 1); // Array indices are zero-based in PHP

// Prompt the user
echo "Please enter the " . ($randomPosition + 1) . "th character of your security code: ";

// Assume $userInput is the character entered by the user
$userInput = '...'; // Replace with actual input mechanism, like form submission

// Get the character at the random position from the security code
$selectedCharacter = $securityCode[$randomPosition];

// Compare the selected character with the user input
if ($userInput === $selectedCharacter) {
    echo "Correct!";
} else {
    echo "Incorrect!";
}

