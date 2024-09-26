export const actions = {

  logout({ commit }) {
    return new Promise((resolve, reject) => {
      try {
        // Perform your log out logic here

        // Clear Vuex store
        commit('RESET_STATE');

        resolve();

      } catch (error) {

        console.log(error);

        reject(error);

      }
    });
  }

};