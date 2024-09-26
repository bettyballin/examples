
$salt = 'your_salt_here'; // This should be a unique and secret value
$answer = 'the_answer'; // The answer you want to hash

// Hash the answer with the salt
$hashedAnswer = hash('sha256', $salt . $answer);

// Now you can send this $hashedAnswer to the client-side along with the questions

