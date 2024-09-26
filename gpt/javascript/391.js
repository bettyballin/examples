
const fs = require('fs');
const solanaWeb3 = require('@solana/web3.js');
const { Keypair, LAMPORTS_PER_SOL, clusterApiUrl } = solanaWeb3;

const connection = new solanaWeb3.Connection(clusterApiUrl('devnet'), 'confirmed');

async function
