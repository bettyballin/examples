const nonce = 'NTVkNjE4NzYtZjg4Mi00MmYwLWIzOTAtZGM2NjJhN2U3Mjc5';
const created = '2021-01-21T18:19:32Z';
const passwordHash = 'olI18mUowhmeCwjb1FJNHtTHYDA=';

console.log(atob(nonce));
console.log(new Date(created));
console.log(atob(passwordHash));