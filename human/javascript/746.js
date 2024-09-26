// Import the necessary libraries
import { createStore } from 'redux';
import { Provider } from 'react-redux';

// Define the initial state of the store
const initialState = {
  isLoggedIn: true
};

// Define the reducer function
const reducer = (state = initialState, action) => {
  switch (action.type) {
    case 'LOG_OUT':
      return { isLoggedIn: false };
    default:
      return state;
  }
};

// Create the store
const appStore = createStore(reducer);

// Define the LogOutAction function
function LogOutAction() {
  return {
    type: 'LOG_OUT'
  };
}

// Dispatch action to change redux store state
appStore.dispatch(LogOutAction());

// Get the current state of the store
console.log(appStore.getState());