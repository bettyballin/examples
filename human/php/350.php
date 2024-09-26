<?php
$userid = 'your_user_id'; // replace with your actual user id
$date = '2011-11-30';

$query = "SELECT COUNT(*) 
FROM blogs 
WHERE user_id = '$userid' 
AND DATE(created) = '$date'";

$result = mysqli_query($conn, $query);

if ($result) {
    $count = mysqli_fetch_row($result)[0];
    echo $count;
} else {
    echo "Error: " . mysqli_error($conn);
}

mysqli_close($conn);
?>