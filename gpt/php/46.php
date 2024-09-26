
function generateSecureRandomString($length) {
    try {
        // Generate random bytes
        $bytes = random_bytes($length);
        
        // Convert to hexadecimal format
        $string = bin2hex($bytes);

        // If you need a string of exactly $length, substr may be used
        // Note: $length should be halved as bin2hex doubles the length of the output
        return substr($string, 0, $length);
    } catch (Exception $e) {
        // Handle exception if random_bytes fails
        // You may want to use a fallback or rethrow the exception
        throw $e;
    }
}

$tokenLength = 32; // Change this to your desired token length
$authToken = generateSecureRandomString($tokenLength);
echo "Authentication
