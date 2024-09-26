
public function configureOptions(OptionsResolver $resolver)
{
    $resolver->setDefaults([
        // ...
        'csrf_protection' => true,
        'csrf_field_name' => '_csrf_token',
        // this is the
