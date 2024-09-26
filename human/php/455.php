private function preventAttack()
{
    $blocked = $this->getData("SELECT count(*) as blocked FROM blacklist WHERE ip = ?", array($_SERVER['REMOTE_ADDR']));
    if ($blocked[0]["blocked"] == "1") {
        $this->redirect("index.php?module=login&task=blacklist");
    }
    $old = (int)$this->session->get("login_attempts");
    if ($old > 0) {
        if (($old + 1) >= SESSION_MAX_ATTEMPTS) {
            $this->setData("INSERT INTO blacklist SET ip = ?", array($_SERVER['REMOTE_ADDR']));
            $this->session->set("login_attempts", 0);
            $this->redirect("index.php?module=login&task=blacklist");
        } else {
            $old++;
            $this->session->set("login_attempts", $old);
        }
    } else {
        $this->session->set("login_attempts", 1);
    }
}