var sCustomUrl = "https://example.com";
var sParam = "path/to/resource";

window.open(new URL(sCustomUrl).origin + "/" + sParam, "_blank", "noopener noreferrer");