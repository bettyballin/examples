// In your store.js file
import Vuex from 'vuex';

const store = new Vuex.Store({
  state: {
    // Example state properties
    user: {},
    token: ''
  },
  mutations: {
    CLEAR_STATE(state) {
      Object.assign(state, {
        // Example default values
        user: {},
        token: ''
      });
    }
  },
  actions: {
    clearState({ commit }) {
      commit('CLEAR_STATE');
      
      // Clear other modules' states if needed
    }
  }
});

// In your logout method
export default {
  methods: {
    async logout() {
      await this.$store.dispatch('clearState');

      // Perform the actual log out operation here...
      // For example, clearing local storage and redirecting to the login page
      localStorage.clear();
      this.$router.push({ name: 'login' });
    }
  }
}