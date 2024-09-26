<?php

interface AppUserInterface
{
    public function getLocale(): ?string;
}

class User implements AppUserInterface
{
    private $locale;

    public function __construct($locale = null)
    {
        $this->locale = $locale;
    }

    public function getLocale(): ?string
    {
        return $this->locale;
    }
}

$user = new User('en_US');
echo $user->getLocale() . "\n";

$user2 = new User();
var_dump($user2->getLocale());