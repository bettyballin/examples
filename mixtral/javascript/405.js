import Constants from 'expo-constants';
import { Platform } from 'react-native';
import NetInfo from '@react-native-community/netinfo';

const IS_DEV = !Constants?.manifest || !!Constants?.dev;

if (!IS_DEV && Platform.OS === "android") {
  NetInfo.fetch().then(state => {
    const isRooted = state.isConnectionExpensive;

    if (isRooted) {
      // Handle jailbreak detection
    }
  });
}