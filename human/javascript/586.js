Here is the executable JavaScript code:


// store.js
import _ from 'lodash';
import Vuex from 'vuex';
import user from './user';
import recruitment from './recruitment';

// Initial store with modules as an object
export const initialStoreModules = {
  user,
  recruitment,
};

export default new Vuex.Store({
  /**
   * Assign the modules to the store 
   * using lodash deepClone to avoid changing the initial store module values
   */
  modules: _.cloneDeep(initialStoreModules),
  mutations: {
    // reset default state modules by looping around the initialStoreModules
    resetState(state) {
      _.forOwn(initialStoreModules, (value, key) => {
        state[key] = _.cloneDeep(value.state);
      });
    },
  }
});