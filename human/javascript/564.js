function decode(input) {
    const separatorSet = new Set(['-', ' ']);
    const components = input.split(new RegExp([...separatorSet].join('|'), 'g'));
    // ...
}