
function securitycheck($html, $css, $js)
{
    // Concatenate the code with unique separators to avoid cross-boundary false negatives.
    $code = $html . "\n--HTML-END--\
