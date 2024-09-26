
// After executing the query...
if (mysqli_num_rows($raw_results) > 0) {
    while ($results = mysqli_fetch_array($raw_results)) {
        echo "<p>" . $results['title'] . " " . $results['name'] . "</p>";
    }
} else {
    echo 'No results found';
}

