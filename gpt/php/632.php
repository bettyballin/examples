
// ... Process the finish action here ...

// Set a session variable indicating completion of Stage 1
$_SESSION['stage1_completed'] = true;

// Redirect to Stage 2
header('Location: stage2.php');
exit;

