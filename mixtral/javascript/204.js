const getDefaultState = () => {
  return {
    // Your default data here
  };
};

export const state = getDefaultState();

// ...

export const mutations = {
  RESET_STATE(state) {
    Object.assign(state, getDefaultState());
  },

  // Other mutation functions
}