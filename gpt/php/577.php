
$conType = $this->params->get('conType', '');

// Assuming '1' means fluid and anything else means fixed
$containerClass = ($conType === "1") ? "container-fluid" : "container";

