<?php

class MyHtmlEncoder extends DefaultEncoder {
    private $allowedTags = ['b', 'i'];

    public function encodeForHTML($input) {
        // First escape all special characters using parent method
        $escapedInput = parent::encodeForHTML($input);

        // Then replace allowed tags with their original form
        foreach ($this->allowedTags as $tag) {
            $escapedTag = htmlspecialchars("<{$tag}>", ENT_QUOTES, 'UTF-8');
            $originalTag = "<{$tag}>";
            $escapedInput = str_replace($escapedTag, $originalTag, $escapedInput);
            
            // Also replace closing tags
            $escapedClosingTag = htmlspecialchars("</{$tag}>", ENT_QUOTES, 'UTF-8');
            $originalClosingTag = "</{$tag}>";
            $escapedInput = str_replace($escapedClosingTag, $originalClosingTag, $escapedInput);
        }

        return $escapedInput;
    }
}

class DefaultEncoder {
    public function encodeForHTML($input) {
        return htmlspecialchars($input, ENT_QUOTES, 'UTF-8');
    }
}

$encoder = new MyHtmlEncoder();
echo $encoder->encodeForHTML("<b>Hello</b> <i>World!</i>");

?>