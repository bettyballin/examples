function getListsForUser(user) {
  if (!user || !user.profile || !user.profile.group) {
    return [];
  }
  return Lists.find({group: user.profile.group});
}

// Example usage:
const user = {
  profile: {
    group: 'exampleGroup'
  }
};

const Lists = {
  find: (query) => {
    // Simulating a database query
    return [{name: 'List 1'}, {name: 'List 2'}];
  }
};

console.log(getListsForUser(user));