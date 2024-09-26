$form = $this->createFormBuilder()
    ->add('name', TextType::class)
    ->add('email', EmailType::class)
    ->add('roles', ChoiceType::class, array(
        'choices' => array(
            'ROLE_USER' => 'User',
            'ROLE_ADMIN' => 'Admin',
        ),
    ))
    ->getForm();