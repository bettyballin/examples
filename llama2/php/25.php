<?php
defined('_JEXEC') or die;

$app = JFactory::getApplication();
$db = $app->get('dbo');

// Get the value of the text box from the request
$value = $app->input->getString('textBoxValue', 'POST');

// Create a query to retrieve the records
$query = "SELECT * FROM #__your_table WHERE your_field LIKE '%".$db->escape($value)."%'";

// Execute the query and get the results
$rows = $db->setQuery($query)->loadObjectList();

// Return the results in JSON format
echo json_encode($rows);
?>