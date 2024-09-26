/**
 * @Route("/page/{page}", name="user_index", requirements={"page"="\d+"}, defaults={"page":1})
 * @Security("is_granted('ROLE_ADMIN') or is_granted('ROLE_RESPONSIBLE')")
 */