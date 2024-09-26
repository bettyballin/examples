
function filter($p){
    return str_replace(
        array("<", ">", "&"),
        array("&lt;", "&gt;", "&amp;"),
        $p
    );
}

