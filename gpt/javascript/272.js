
actions: {
  logout({ commit }) {
    // Perform logout operations like clearing tokens from localStorage, etc.
    commit('RESET_STATE');
    // Redirect the user or perform
