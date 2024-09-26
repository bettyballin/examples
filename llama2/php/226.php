$oldAcl = $this->get('security.context')->findAclByUsername($previousUsername);
if ($oldAcl) {
    $oldAcl->delete();
    $this->getDoctrine()->getManager()->flush();
}