function getCommonDictionaryWords() {
    $words = array(
        'password', 'qwerty', 'letmein', 'dragonball', 'baseball', 'iloveyou', 'trustno1', '000000', 'pass123', 'password123',
        'welcome', 'login', 'sunshine', 'princess', 'football', 'jennifer', 'benjamin', 'monkey', 'master', 'hannah',
        'charlie', 'tiger', 'silver', 'daniel', 'samuel', 'william', 'oliver', 'peanut', 'purple', 'orange', 'banana',
        'family', 'friend', 'flower', 'butterfly', 'love', 'god', 'music', 'video', 'game', 'player', 'summer', 'winter',
        'spring', 'autumn', 'holiday', 'trip', 'car', 'house', 'tree', 'fish', 'bird', 'phone', 'camera', 'computer',
        // Add more words here...
    );
    return $words;
}

function checkPasswordContainsCommonWord($password) {
    $words = explode(' ', $password);
    foreach ($words as $word) {
        if (in_array(strtolower($word), getCommonDictionaryWords())) {
            return true;
        }
    }
    return false;
}

$password = "Hello World";
echo var_export(checkPasswordContainsCommonWord($password), true) . "\n";

$password = "mysecretpassword";
echo var_export(checkPasswordContainsCommonWord($password), true) . "\n";