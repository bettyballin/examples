<?php

class User {
    public $data;

    function __construct($groupId) {
        $this->data['user']['group_id'] = $groupId;
    }
}

$rawAllow = array(2,3,4);
$allowed = array_flip($rawAllow);

$user = new User(3);

if (isset($allowed[$user->data['user']['group_id']])) {
    echo "User is allowed to perform the action.";
} else {
    echo "User is not allowed to perform the action.";
}