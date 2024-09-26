<?php
$query = "SELECT * FROM users WHERE ID = '$the_id'";
$select_posts = mysqli_query($connection, $query);
$num_rows = mysqli_num_rows($select_posts);

if($num_rows == 0) {
    // You can't use both echo and header at the same time, use one of them
    // echo "something else";
    header("Location: errorpage.php");
    exit;
} else {
    while($row = mysqli_fetch_assoc($select_posts)) {
        // your code here
        // example: echo $row['column_name'];
    }
}
?>