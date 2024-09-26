<?php

require_once 'HTMLPurifier.auto.php';

class CustomFilter extends HTMLPurifier_AttrDef {
    public function validate($string, $config) {
        // Your validation logic here

        return parent::validate($string, $config);
    }
}

$config = HTMLPurifier_Config::createDefault();
$purifier = new HTMLPurifier($config);
$def = $purifier->config->getHTMLDefinition(true);

// Register the new filter
$customFilter = new CustomFilter();

if ($def && !empty($def->info['blockquote'])) {
    // Add your custom attribute to blockquotes

    if (!isset($def->info['blockquote']['attr_transform_post']['data-author']) ||
        $def->info['blockquote']['attr_transform_post']['data-author'] instanceof HTMLPurifier_AttrDef
    ) {
        $def->addAttribute('blockquote', 'data-author', new CustomFilter());
    }
}

$html = '<blockquote data-author="John Doe">Quote</blockquote>';
$cleanHtml = $purifier->purify($html);

echo $cleanHtml;

?>