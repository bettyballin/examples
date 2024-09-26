
session_start();

function canAttemptLogin() {
    if (!isset($_SESSION['login_attempts']) || !isset($_SESSION['blocked_until'])) {
        return true;
    }

    if ($_SESSION['login_attempts'] >= 3) {
        if (time() < $_SESSION['blocked_until']) {
            return false;
        }
    }

    return true;
}

function recordFailedLogin() {
    if (!isset($_SESSION['login_attempts'])) {
        $_SESSION['login_attempts'] = 0;
    }
    $_SESSION['login_attempts']++;

    if ($_SESSION['login_attempts'] >= 3) {
        // Block for 10 minutes
        $_SESSION['blocked_until'] = time() + (10 * 
