<?php

class PhoneApplication {
    public function get($service) {
        // assuming this method returns an instance of a class that has the userApplication method
        return new TestUserApplication();
    }
}

class TestUserApplication {
    public function userApplication($id) {
        // your logic here
        echo "User application with id: $id";
    }
}

$phoneApplication = new PhoneApplication();
$serv = $phoneApplication->get('phone_application.test_user_application');
$id = 1; // replace with your id
$serv->userApplication($id);

?>