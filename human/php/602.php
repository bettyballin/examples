<?php
function pdoSet($fields, &$values, $source = array()) {
  $set = '';
  $values = array();
  if (!$source) $source = &$_POST;
  foreach ($fields as $field) {
    if (isset($source[$field])) {
      $set.="`".str_replace("`","``",$field)."`". "=:$field, ";
      $values[$field] = $source[$field];
    }
  }
  return substr($set, 0, -2); 
}

$fields = array('field1', 'field2', 'field3');
$_POST = array('field1' => 'value1', 'field2' => 'value2');
$values = array();
echo pdoSet($fields, $values);
print_r($values);
?>