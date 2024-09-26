public function buildForm(FormBuilderInterface $builder, array $options) {
    //...

    $builder->add('password', RepeatedType::class, [
        'type' => PasswordType::class,
        'invalid_message' => 'Password fields do not match.',
        'required' => false,
    ]);

    // ...
}