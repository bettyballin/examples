
$referer = $_SERVER['HTTP_REFERER'];
$refererData = parse_url($referer);

// Check if the path starts with /search
if (isset($refererData['host']) && $refererData['host'] == 'www.domain.com' &&
    isset($refererData['path']) && strpos($refererData['path'], '/search') === 0) {
    // do stuff...
}

