
$url = 'https://example.com/path/to/file.xml'; // Replace with the actual URL
$filePath = '/path/to/save/file.xml'; // Replace with the path where you want to save the file

// Initialize cURL session
$ch = curl_init($url);

// Set cURL options
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false); // Disable SSL certificate verification
curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, false); // Disable host verification
curl_setopt($ch, CURLOPT_USERAGENT, 'XYZ'); // Set custom User-Agent
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true); // Follow redirects if any
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); // Return the transfer as a string

// Execute cURL session
$content = curl_exec($ch);

// Check for errors
if (curl_errno($ch)) {
    $error_msg = curl
