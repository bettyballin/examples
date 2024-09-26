/**
 * @Route("/page/{page}", name="user_index", requirements={"page"="\d+"}, defaults={"page":1})
 * @IsGranted({"ROLE_ADMIN", "ROLE_RESPONSIBLE"})
 */