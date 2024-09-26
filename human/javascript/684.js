async function writeCode() {
  return "some code";
}

async function pushCodeToGitHub(code) {
  console.log("Pushing code to GitHub:", code);
}

async function doSomethingUnrelated() {
  console.log("Doing something unrelated");
}

async function youCouldBeForgivenForDoingThis() {
  await Promise.all([
    pushCodeToGitHub(await writeCode()),
    doSomethingUnrelated()
  ]);
}

async function armedWithEsotericJSKnowledge() {
  await Promise.all([
    writeCode().then(code => pushCodeToGitHub(code)),
    doSomethingUnrelated()
  ]);
}

youCouldBeForgivenForDoingThis();
armedWithEsotericJSKnowledge();