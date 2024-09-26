<?php
use Joomla\CMS\Factory;

$input = Factory::getApplication()->input->getString('param_name');

// Remove HTML tags
$sanitizedInput = Joomla\CMS\Filter\OutputFilter::clean($input);

// Or use other filter methods like strip_tags intval etc.

print($sanitizedInput);
?>