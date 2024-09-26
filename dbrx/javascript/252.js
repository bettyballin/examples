const solanaWeb3 = require("@solana/web3.js");
const splToken = require("@solana/spl-token");

(async () => {
  // Connect to cluster
  var connection = new solanaWeb3.Connection(
    solanaWeb3.clusterApiUrl("devnet"), "confirmed"
  );

  // Generate a new wallet keypair and mint tokens
  const payerKeypair = solanaWeb3.Keypair.generate();
  console.log("payer public key:", payerKeypair.publicKey.toString());
  console.log("private key:", JSON.stringify(payerKeypair.secretKey));

  let tokenMint = await splToken.Token.createMint(
    connection,
    payerKeypair,
    null, // mint authority
    null, // freeze authority
    9, // decimals
    splToken.TOKEN_PROGRAM_ID
  );

  console.log("token public key:", tokenMint.publicKey.toString());

  let destinationAccount = await tokenMint.createAssociatedTokenAccount(
    payerKeypair.publicKey
  );
  console.log("destination account:", destinationAccount.address.toString());

  const mintAmount = new splToken.u64(1000000);
  await tokenMint.mintTo(destinationAccount, payerKeypair, [], mintAmount);

})();