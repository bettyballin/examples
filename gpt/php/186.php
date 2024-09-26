
function isValidImageUrl($url) {
    $pattern = '/^https?:\/\/.*\.(?:png|jpg|jpeg|gif)$/i';
    return preg_match($pattern, $url);
}

