(async () => {
  try {
    await this.$store.dispatch('logout');
    // Handle successful logout
  } catch (error) {
    console.log(error);
  }
})();