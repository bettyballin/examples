function Cipher(inArray, w) {
    const Nb = 4; // number of columns
    const Nr = 10; // number of rounds
    const state = [...inArray];

    AddRoundKey(state, w.slice(0, Nb));

    for (let round = 1; round < Nr; round++) {
        SubBytes(state);
        ShiftRows(state);
        MixColumns(state);
        AddRoundKey(state, w.slice(round * Nb, (round + 1) * Nb));
    }

    SubBytes(state);
    ShiftRows(state);
    AddRoundKey(state, w.slice(Nr * Nb, (Nr + 1) * Nb));

    return state;
}

function InvCipher(inArray, w) {
    const Nb = 4; // number of columns
    const Nr = 10; // number of rounds
    const state = [...inArray];

    AddRoundKey(state, w.slice(Nr * Nb, (Nr + 1) * Nb));

    for (let round = Nr - 1; round > 0; round--) {
        InvShiftRows(state);
        InvSubBytes(state);
        AddRoundKey(state, w.slice(round * Nb, (round + 1) * Nb));
        InvMixColumns(state);
    }

    InvShiftRows(state);
    InvSubBytes(state);
    AddRoundKey(state, w.slice(0, Nb));

    return state;
}

// Helper functions
function AddRoundKey(state, roundKey) {
    for (let i = 0; i < state.length; i++) {
        state[i] ^= roundKey[i];
    }
}

function SubBytes(state) {
    for (let i = 0; i < state.length; i++) {
        state[i] = sbox[state[i]];
    }
}

function InvSubBytes(state) {
    for (let i = 0; i < state.length; i++) {
        state[i] = invSbox[state[i]];
    }
}

function ShiftRows(state) {
    for (let i = 1; i < 4; i++) {
        const row = state.slice(i * 4, (i + 1) * 4);
        for (let j = 0; j < i; j++) {
            row.push(row.shift());
        }
        for (let j = 0; j < 4; j++) {
            state[i * 4 + j] = row[j];
        }
    }
}

function InvShiftRows(state) {
    for (let i = 1; i < 4; i++) {
        const row = state.slice(i * 4, (i + 1) * 4);
        for (let j = 0; j < i; j++) {
            row.unshift(row.pop());
        }
        for (let j = 0; j < 4; j++) {
            state[i * 4 + j] = row[j];
        }
    }
}

function MixColumns(state) {
    for (let i = 0; i < 4; i++) {
        const col = state.slice(i, state.length, 4);
        state[i] = gmul(col[0], 2) ^ gmul(col[1], 3) ^ col[2] ^ col[3];
        state[i + 4] = col[0] ^ gmul(col[1], 2) ^ gmul(col[2], 3) ^ col[3];
        state[i + 8] = col[0] ^ col[1] ^ gmul(col[2], 2) ^ gmul(col[3], 3);
        state[i + 12] = gmul(col[0], 3) ^ col[1] ^ col[2] ^ gmul(col[3], 2);
    }
}

function InvMixColumns(state) {
    for (let i = 0; i < 4; i++) {
        const col = state.slice(i, state.length, 4);
        state[i] = gmul(col[0], 14) ^ gmul(col[1], 9) ^ gmul(col[2], 13) ^ gmul(col[3], 3);
        state[i + 4] = gmul(col[0], 3) ^ gmul(col[1], 14) ^ gmul(col[2], 9) ^ gmul(col[3], 13);
        state[i + 8] = gmul(col[0], 13) ^ gmul(col[1], 3) ^ gmul(col[2], 14) ^ gmul(col[3], 9);
        state[i + 12] = gmul(col[0], 9) ^ gmul(col[1], 13) ^ gmul(col[2], 3) ^ gmul(col[3], 14);
    }
}

function gmul(a, b) {
    let r = 0;
    for (let i = 0; i < 8; i++) {
        if (b & 1) {
            r ^= a;
        }
        a = (a << 1) ^ (a & 0x80 ? 0x11b : 0);
        b >>= 1;
    }
    return r;
}

// sbox and invSbox are predefined arrays of 256 bytes each
const sbox = [...];
const invSbox = [...];