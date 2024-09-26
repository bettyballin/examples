
// Assuming you have a database connection $conn

if(isset($_POST['lastmsg'])) {
    $lastmsg = $_POST['lastmsg'];

    // Create a prepared statement
    if ($stmt = $conn->prepare("SELECT * FROM updates WHERE item_id < ? ORDER BY item_id DESC LIMIT 16")) {
        
        // Bind the $lastmsg variable to the prepared statement as an integer
        $stmt->bind_param("i", $lastmsg); // 'i' denotes the type of the parameter (integer)

        // Execute the query
        $stmt->execute();

        // Get the result
        $result = $stmt->get_result();

        // Fetch data
        while ($row = $result->fetch_assoc()) {
            $msg_id = $row['item_id'];
            $message = $row['item_content'];
            //
