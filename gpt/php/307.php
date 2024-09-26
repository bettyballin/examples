
$id = (int) $_POST['id'];
$content = $_POST['post_content']; // Directly get the content without filtering

// Prepare the statement
$stmt = $conn->prepare("UPDATE `posts` SET `content` = ? WHERE `id` = ?");

// Bind parameters
$stmt->bind_param("si", $content, $id); // "si" means string and integer respectively

// Execute the prepared statement
$stmt->execute();

// Check for errors
if ($stmt->error) {
    // Handle error
    echo "Error: " . $stmt->error;
}

// Close the statement
$stmt->close();

