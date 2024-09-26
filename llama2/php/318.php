<?php
$query_research_str = 'test_string';
$pattern = '/^[a-zA-Z0-9_]+$/';

if (!preg_match($pattern, $query_research_str)) {
    echo "Invalid input";
} else {
    echo "Valid input";
}
?>