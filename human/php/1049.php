<?php
class Auth
{
    protected
        $username=null,
        $password=null;

    public function setCredentials($username,$password)
    {
        $this->username=$username;
        $this->password=$password;
    }

    public function login()
    {
        $result=false;
        //credentials are not passed to this function
        //so if something goes wrong they won't end up
        //in the stack trace
        $data = $this->retrieveUserRecordFromDatabase();
        $result=password_verify($this->password,$data['password_hash']);
        if($result)
        {
            $this->finishLoggingUserIn();
        }
        return $result;
    }

    private function retrieveUserRecordFromDatabase()
    {
        // replace with actual database retrieval logic
        return array('password_hash' => 'your_hash_here');
    }

    private function finishLoggingUserIn()
    {
        // replace with actual login completion logic
    }
}

// example usage:
$auth = new Auth();
$auth->setCredentials('your_username', 'your_password');
if ($auth->login()) {
    echo "Logged in successfully!";
} else {
    echo "Login failed.";
}