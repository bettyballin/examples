
// Your web service WSDL URL
$wsdl = 'https://example.com/service?wsdl';

// Options for the SoapClient
$options = [
    'trace' => true,  // Enable tracing for debugging purposes
    'exceptions' => true,  // Throw exceptions on error
    'cache_wsdl' => WSDL_CACHE_NONE,  // Disable caching of WSDL
    'stream_context' => stream_context_create([
        'ssl' => [
            '
