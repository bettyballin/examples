/**
 * @param Request $request
 * @return Response
 *
 * @Route("/someroute", name="something")
 * @Method(methods={"POST", "GET"})
 */
public function calculatorAction(Request $request)
{
    if (!$this->get('security.authorization_checker')->isGranted('IS_AUTHENTICATED_FULLY') && $request->getMethod() == 'POST') {
        throw new AccessDeniedHttpException();
    }

    $form = $this->createForm(new CallRequestType(), $callReq = new CallRequest());

    $form->handleRequest($request);

    // you also need to check submitted or youll fire the validation on every run through.
    if ($form->isSubmitted() && $form->isValid()) {
        //blabla
    }

    return $this->render('MyBundle:Pages:calculator.html.twig', array('form' => $form->createView()));
}