Here is the executable code:


const solanaWeb3 = require("@solana/web3.js");
const solanaToken = require('@solana/spl-token');

(async () => {
  // Connect to cluster
  const connection = new solanaWeb3.Connection(
    solanaWeb3.clusterApiUrl("devnet"),
    "confirmed"
  );

  // Generate a new wallet key pair and air drop SOL
  let wallet = solanaWeb3.Keypair.generate();

  console.log(`publicKey: ${wallet.publicKey}`);

  // Airdrop SOL to the wallet
  const airdropSignature = await connection.requestAirdrop(wallet.publicKey, 1 * solanaWeb3.LAMPORTS_PER_SOL);
  await connection.confirmTransaction(airdropSignature);

  console.log("Airdrop successful");
})();