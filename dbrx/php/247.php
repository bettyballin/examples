// In your controller action

$authenticationUtils = $this->get('security.authentication_utils');
$error = $authenticationUtils->getLastAuthenticationError();
$lastUsername = $authenticationUtils->getLastUsername();

$sessionFlashBag = $this->get('session')->getFlashBag();
$formDataFromSession = [];
if ($sessionFlashBag->has('my_form_data')) {
    // Retrieve the form data from session.flashBag
    foreach ($sessionFlashBag->get('my_form_data') as $name => $data) {
        if (is_array($data)) {
            array_walk_recursive($data, function (&$value) use ($data) {
                $value = isset($data[$value]) ? $data[$value] : null;
            });
            $formDataFromSession[$name] = $data;
        } else {
            $formDataFromSession[$name] = $data;
        }
    }

    // Clear the session.flashBag
    $sessionFlashBag->clear();
}

$form = $this->createForm(MyFormType::class, array_merge([], $formDataFromSession));