<?php
  // configuration
  $url = 'path/to/script.php';
  $fields = array(
    'field1' => 'value1',
    'field2' => 'value2',
    'field3' => 'value3'
  );

  // create form
  $form = '<form action="' . $url . '" method="post">';
  foreach ($fields as $key => $value) {
    $form .= '<input type="text" name="' . $key . '" value="' . $value . '">';
  }
  $form .= '</form>';

  // output form
  echo $form;
?>