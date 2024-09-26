<?php
class User {
    public function update($data) {
        // Update user data
        // For demonstration purposes, let's just print the updated data
        print_r($data);
    }
}

class Session {
    public static function getId() {
        // Return the session ID
        // For demonstration purposes, let's just return a hardcoded ID
        return 'some_session_id';
    }
}

$user = new User();
$user->update(['session_id' => Session::getId()]);
?>