<?php
session_start();

// Assuming you have a database connection established
$conn = mysqli_connect("localhost", "username", "password", "database");

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Retrieve event data from database
$event_id = $_GET['event_id']; // Assuming event ID is passed through URL
$query = "SELECT * FROM events WHERE event_id = '$event_id'";
$event_result = mysqli_query($conn, $query);
$event_result = mysqli_fetch_assoc($event_result);

// Check if user is authorized to edit event
if( $_SESSION['user_id'] == $event_result['user_id'] ) {
    // They match, show the form
    ?>
    <form action="edit_event.php" method="post">
        <!-- Your form fields here -->
        <input type="submit" value="Edit Event">
    </form>
    <?php
}else {
    // they don't match
    echo 'Excuse me, what are you doing?';
}

mysqli_close($conn);
?>