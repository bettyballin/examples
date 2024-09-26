<?php
class AppModel {}

class User extends AppModel {
    function hashPasswords($data) {
        if (isset($data['User']['password'])) {
            //Get the user to get the salt
            $user = $this->findByUsername($data['User']['username']);
            //Let's say you have a "salt" field in your db 
            $data['User']['password'] = md5($data['User']['password'].$user['User']['salt']);
            return $data;
        }
        return $data;
    }

    function findByUsername($username) {
        // dummy user data for demonstration purposes
        $users = array(
            array('User' => array('username' => 'john', 'salt' => 'mysecretsalt')),
        );
        foreach ($users as $user) {
            if ($user['User']['username'] == $username) {
                return $user;
            }
        }
        return null;
    }
}

// create a new user and hash the password
$user = new User();
$data = array('User' => array('username' => 'john', 'password' => 'mysecretpassword'));
print_r($user->hashPasswords($data));
?>