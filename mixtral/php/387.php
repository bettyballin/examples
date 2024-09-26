public function retrieveData() {
    $conn = parent::connected();
    $inactive = 0;
    $sql = "SELECT * FROM `category` WHERE term_status != :status";
    $stmt = $conn->prepare($sql);
    $stmt->bindParam(":status", $inactive, PDO::PARAM_INT);
    $stmt->execute();

    // Fetch all data and store it in an associative array
    $data = $stmt->fetchAll(PDO::FETCH_ASSOC);

    // Wrap the fetched data inside another object
    $responseData = ['objects' => $data];

    return json_encode($responseData, JSON_PRETTY_PRINT | JSON_UNESCAPED_SLASHES);
}