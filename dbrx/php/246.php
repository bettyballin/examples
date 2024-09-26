// In your controller action

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Session\SessionInterface;
use Symfony\Component\Form\FormInterface;

$form = $this->createForm(MyFormType::class);
$request = $this->getRequest();
$sessionFlashBag = $request->getSession()->getFlashBag();

if ($form->handleRequest($request)->isValid() && !$this->getUser()) {
    // Save the submitted values in session.flashBag
    foreach ($form as $name => $field) {
        if (!$field instanceof FormInterface || null === $data = $field->getData()) {
            continue;
        }

        $sessionFlashBag->set('my_form_data_'.$name, $data);
    }
    
    // Redirect user to registration page
    return $this->redirectToRoute('registration');
}