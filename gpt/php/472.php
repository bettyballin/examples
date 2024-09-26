
$url = 'http://example.com/page';
$hash = hash('sha256', $url); // Create a SHA-256 hash of the URL

// Append a unique identifier, like a current timestamp or a random value
$uniqueId = uniqid();

// Combine the hash and unique ID
$encodedFilename = $hash . '_' . $uniqueId . ".html"; // Ensures uniqueness

// Use the encoded filename as the cache file name
$file = $encodedFilename;

