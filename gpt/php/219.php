
$allowedSortOptions = ['name', 'date', 'rating'];
$sort = $_POST['sort'];
if (in_array($sort, $allowedSortOptions)) {
    // It's safe to use $sort in your SQL query
}

