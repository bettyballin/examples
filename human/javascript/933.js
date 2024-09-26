(async () => {
  const solanaWeb3 = require('@solana/web3.js');
  const connection = new solanaWeb3.Connection(solanaWeb3.clusterApiUrl('devnet'));
  const wallet = new solanaWeb3.Keypair.generate();

  var airdropSignature = await connection.requestAirdrop(
    wallet.publicKey,
    solanaWeb3.LAMPORTS_PER_SOL
  );
})();