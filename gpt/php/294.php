
function safeLoadHTMLFile($url) {
    $doc = new DOMDocument();

    // Configure libxml error handling
    libxml_use_internal_errors(true);

    // Set up a stream context with timeout and user-agent
    $context = stream_context_create([
        'http' => [
            'timeout' => 10,
