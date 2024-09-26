<?php
defined('_JEXEC') or die;

$db = JFactory::getDBO();
$query = $db->getQuery(true);
$filter = "com_content,com_users"; // example filter, replace with your own
$option = "com_example"; // example option, replace with your own

$query
    ->select('element')
    ->from('#__extensions')
    ->where('type = ' . $db->quote('component'))
    ->where('element NOT IN ('. $db->quote($filter) . ')')
    ->where('element = ' . $db->quote($option));
$component = $db->setQuery($query)->loadResult();

print_r($component);
?>