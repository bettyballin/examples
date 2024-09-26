<?php
if (isset($_POST['submit_login'])) {

    if (isset($_POST['username']) && isset($_POST['password'])) {
        $username = mysql_real_escape_string($_POST['username']);
        $password = mysql_real_escape_string($_POST['password']);
        // id = unique primary key
        $rs = mysql_query("SELECT id, Username, Password, Failed_logins, IP_address FROM Users WHERE Username = '$username'");
        $num = mysql_num_rows($rs);
        if ($num > 0) {
            // I would add a password hash here to $password, and check against the hashed Password from the database
            // But let's check the clean passwords
            $row = mysql_fetch_array($rs);
            if ($password == $row['Password']) {
                // Successful login, set session or whatever you need
                // Reset failed logins
                mysql_query("UPDATE Users SET Failed_logins = 0 WHERE id = '{$row['id']}'");
                header('location: success.php');
                exit;
            } else {
                // Failed password check
                if ($row['Failed_logins'] > 3) {
                    // Redirect to captcha
                    header('location: captcha.php');
                    exit;
                } else {
                    $ip = $_SERVER['REMOTE_ADDR'];
                    if ($row['IP_address'] != $ip) {
                        // New ip adress, reset failed logins
                        $failed_logins = 0;
                    } else {
                        // Increment failed logins
                        $failed_logins = $row['Failed_logins']+1;
                    }
                    mysql_query("UPDATE Users SET Failed_logins = $failed_logins, IP_address = '$ip' WHERE id = '{$row['id']}'");
                } // End check Failed_logins > 3
            }
        } else {
            // No such Username found in database
            $error = 'no_such_username';
        } // End username check from database

    } else {
        // Either username or password is missing
        $error = 'incomplete_form';
    } // end check for username and password

} // end main submit_login check
?>