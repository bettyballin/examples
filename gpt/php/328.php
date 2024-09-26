
// Assuming you have a PDO connection $pdo and $auth->id is the user ID.
$activityType = 'blog_post';
$userId = $auth->id;
$maxPostsPerDay = 3;

// Prepare the SQL query to count user activities in the last 24 hours.
$stmt = $pdo->prepare("SELECT COUNT(*) FROM user_activity_log WHERE user_id = :user_id AND activity_type = :activity_type AND timestamp > (NOW() - INTERVAL 1 DAY)");
$stmt->
