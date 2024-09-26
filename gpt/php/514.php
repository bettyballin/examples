
->add('password', 'repeated', array(
    'type' => 'password',
    'required' => false, // Make this field optional
    'invalid_message' => 'Password fields do not match',
    'first_options' => array('label' => 'Password (leave blank if you do not want to change it)'),
    'second_options' => array('label' => 'Repeat Password (leave blank if you do not want to change it)'),
))

