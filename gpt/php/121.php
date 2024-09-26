
$text = preg_replace('/\[LINK\=([\'"])?(https?:\/\/(?:www\.)?domain\.com[^\'" ]*)\1\](.*?)\[\/LINK\]/is', '<a href="$2">$3</a>', $text);

