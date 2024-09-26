const document = {
  "7799389_me@domain.com": {
    id: 7799389,
    email: "me@domain.com"
  }
};

const getDocument = (documentName) => {
  const [id, email] = documentName.split("_");
  if (document[documentName] && document[documentName].id == id && document[documentName].email == email) {
    return document[documentName];
  } else {
    return "Access denied";
  }
};

console.log(getDocument("7799389_me@domain.com"));