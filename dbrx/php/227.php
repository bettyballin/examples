<?php
require_once 'HTMLPurifier.auto.php';

$config = HTMLPurifier_Config::createDefault();
$def = $config->getHTMLDefinition(true);
$def->addAttribute('blockquote', 'data-author', new HTMLPurifier_AttrDef_Text());

$purifier = new HTMLPurifier($config);

// example usage
$dirty_html = '<blockquote data-author="John Doe">This is a quote.</blockquote>';
$clean_html = $purifier->purify($dirty_html);

echo $clean_html;