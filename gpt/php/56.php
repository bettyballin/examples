
// Replace occurrences of insert, update, delete, select
$dmlArray = array('select', 'update', 'delete', 'insert');

// Assuming $clean['comment'] contains the original string
$originalComment = $clean['comment'];

// Perform the replacement
$replacedComment = str_ireplace($dmlArray, '-- replaced DML --', $originalComment, $Incount);

// Now $replacedComment contains the replaced string, and $Incount contains the count of replacements
echo $replacedComment;

