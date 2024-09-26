<?php
echo $this->Form->create('User', array(
    'class' => 'form-horizontal',
    'role' => 'form',
    'url' => array('controller' => 'users', 'action' => 'login'),
    'blackHole' => false
));