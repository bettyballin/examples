<?php
use Kreait\Firebase\Factory;

$factory = (new Factory)->withServiceAccount('path/to/your/service-account.json');

$auth = $factory->createAuth();

$newUser = $auth->createUserWithEmailAndPassword('<EMAIL>', 'password');