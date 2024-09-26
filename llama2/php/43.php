<?php

class BBCodeParser {
    public function parse($text) {
        $text = preg_replace('/\[(b|B)\](.*?)\[\/(b|B)\]/', '<b>$2</b>', $text);
        $text = preg_replace('/\[(i|I)\](.*?)\[\/(i|I)\]/', '<i>$2</i>', $text);
        $text = preg_replace('/\[(u|U)\](.*?)\[\/(u|U)\]/', '<u>$2</u>', $text);
        $text = preg_replace('/\[(url|URL)\](.*?)\[\/(url|URL)\]/', '<a href="$2">$2</a>', $text);
        $text = preg_replace('/\[(url|URL)=(.*?)\](.*?)\[\/(url|URL)\]/', '<a href="$2">$3</a>', $text);
        $text = preg_replace('/\[(img|IMG)\](.*?)\[\/(img|IMG)\]/', '<img src="$2" />', $text);
        return $text;
    }
}

$userInput = '[b]Hello[/b] [i]World[/i]!';
$bbCode = new BBCodeParser();
$text = $bbCode->parse($userInput);
print($text);

?>