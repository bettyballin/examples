
$input = JFactory::getApplication()->input;
$dirtyString = $input->getString('form_field_name', '');  // Replace 'form_field_name' with the actual field name
$cleanString = JFilterInput::getInstance()->clean($dirtyString, 'string'); // Sanitize as string

