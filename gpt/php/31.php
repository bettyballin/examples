
// Assuming $_GET['tags'] = "apples, oranges, bananas, grapes, cherries"

// Separate the tags into an array
$rawTags = explode(',', $_GET['tags']);

// Trim whitespace and sanitize each tag
$tags = array_map(function ($tag) {
    return htmlspecialchars(trim($tag));
}, $rawTags);

// $tags now contains the sanitized array of tags

