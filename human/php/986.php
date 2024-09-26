<?php

class GenericEvent {
    private $subject;
    private $arguments;

    public function __construct($subject, array $arguments = array()) {
        $this->subject = $subject;
        $this->arguments = $arguments;
    }

    public function getSubject() {
        return $this->subject;
    }
}

class User {
    // User class implementation
}

class UserEvent extends GenericEvent {
    public function __construct(User $user, array $arguments = array()) {
        parent::__construct($user, $arguments);
    }

    /**
     * @return User
     */
    public function getUser() {
        return $this->getSubject();
    }
}

// Example usage
$user = new User();
$event = new UserEvent($user);
print_r($event->getUser());