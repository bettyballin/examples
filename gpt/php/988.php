
public function retrieveData() {
    $conn = parent::connected();
    $inactive = '0';
    $sql = "SELECT * FROM `category` WHERE term_status != :status";
    $stmt = $conn->prepare($sql);
    $stmt->bindParam("status", $inactive, PDO::PARAM_INT);
    $stmt->execute();
    $results = $stmt->fetchAll(PDO::FETCH_ASSOC);
    return array("data" => $results); // Wrap the result array within another array with a key 'data'
}

