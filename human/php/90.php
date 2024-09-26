<?php
require_once 'HTMLPurifier.auto.php';

// load the config and override defaults as necessary
$config = HTMLPurifier_Config::createDefault();
$config->set('HTML', 'Doctype', 'XHTML 1.0 Transitional');
$config->set('HTML', 'AllowedElements', 'a,em,blockquote,p,strong,pre,code');
$config->set('HTML', 'AllowedAttributes', 'a.href,a.title');
$config->set('HTML', 'TidyLevel', 'light');