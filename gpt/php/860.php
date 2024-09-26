
function isValidElasticsearchId($id) {
    return preg_match('/^[a-zA-Z0-9\-_]+$/i', $id);
}

// Example usage
$id = "your_elasticsearch_id_here";

if (isValidElasticsearchId($id)) {
    // Proceed with querying Elasticsearch
} else {
    // Invalid ID format, handle accordingly
}

