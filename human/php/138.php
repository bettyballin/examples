<?php
$text = '[LINK=https://www.example.com]Example Link[/LINK]';
$text = preg_replace_callback("/\[LINK\=(.*?)\](.*?)\[\/LINK\]/is",
    function (array $matches) {
        if (filter_var($matches[1], FILTER_VALIDATE_URL))
            return '&lt;a href="'.
                htmlspecialchars($matches[1], ENT_QUOTES).
                '" target="_blank"&gt;'.
                htmlspecialchars($matches[2])."&lt;/a&gt;";
        else
            return "INVALID MARKUP";
    }, $text);
print($text);
?>