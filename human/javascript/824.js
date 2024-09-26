function checkLogin() {
  axios
    .get('/webapi/check')
    .then(() => {})
    .catch(err => {
      if (err.response.status === 401) {
        // use a mutation to toggle your "loggedIn" state
        this.$store.commit('loggedIn', false)
        if (this.$route.path !== '/login') {
          this.$router.push('/login')
        }
      }
    })
}