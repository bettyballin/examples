
libxml_set_external_entity_loader(function($public, $system, $context) {
    // Reject loading any external entities
    return false;
});

