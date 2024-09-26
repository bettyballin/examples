
session_start();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $password = $_POST['password'];
    $action = $_POST['action']; // 'REMOVE' or 'CHANGE'

    // Perform password validation
    $isPasswordCorrect = checkPassword($password);

    if ($isPasswordCorrect) {
        if ($action == 'REMOVE') {
            $_SESSION['classified_id_to_remove'] = $_POST['classified_id'];
            header('Location: remove_classified.php');
            exit();
        } elseif ($action == 'CHANGE') {
            $_SESSION['classified_id_to_change'] = $_POST['classified_id'];
