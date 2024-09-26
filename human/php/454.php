<?php
$conn = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

$userID = $_GET['userID'];

$sql = "SELECT * FROM persons WHERE id = :userid";

$q = $conn->prepare($sql);
$q->execute(array(':userid' => $userID ));

while($r = $q->fetch(PDO::FETCH_ASSOC)){ 
    echo '<div class="mis-per">'; 
    echo '<span class="date-submitted">' . $r['date_submitted'] . '</span>'; 
    // MORE STUFF 
    echo '</div>'; 
}
?>