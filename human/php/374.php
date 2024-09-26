// /application/Models/DbTable/Track.php
public function deleteTrack($trackId) {

    $trackRowset = $this->find($trackId);
    $trackToGo = $trackRowset->current();

    $usedBy = $trackToGo->findDependentRowset('Application_Model_DbTable_Member');
    if (count($usedBy) == 0) {

        $where = $this->getAdapter()->quoteInto('trackid = ?', $trackId);

        $this->delete($where);
    } else {
        throw new Zend_Exception('Track is still assigned to member(s) and cannot be deleted.'
            . "<br />" . 'Members: ' . count($usedBy));
    }
}