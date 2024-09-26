let openSSHPublicKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC8...";
let openSSHPublicKeyMaterial = openSSHPublicKey.split(" ")[1];
let formattedSSH2KeyArray = []
formattedSSH2KeyArray.push('---- BEGIN SSH2 PUBLIC KEY ----');
formattedSSH2KeyArray.push('Comment: ""');

for (let index = 0; index <= openSSHPublicKeyMaterial.length; index += 64 ) { 
    let singleLine = openSSHPublicKeyMaterial.substring(index, index + 64);
    formattedSSH2KeyArray.push(singleLine);
}

formattedSSH2KeyArray.push('---- END SSH2 PUBLIC KEY ----');
let formattedSSH2Key = formattedSSH2KeyArray.join('\n');
console.log(formattedSSH2Key);