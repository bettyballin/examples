<?php
$dbresult = array('field' => 'Test <b>string</b>');
echo htmlentities($dbresult['field'], ENT_QUOTES | ENT_HTML5, 'UTF-8');
?>