<?php
$allowedColumns = array('user_name', 'email', 'created_at');
$query_research_str = 'email';  // example input

if (in_array($query_research_str, $allowedColumns)) {
    echo "Allowed column: $query_research_str";
} else {
    echo "Invalid input: $query_research_str";
}
?>