$form = $this->createFormBuilder()
    ->setAction($this->generateUrl('delete_record', ['id' => $recordId]))
    ->setMethod('DELETE')
    ->getForm();