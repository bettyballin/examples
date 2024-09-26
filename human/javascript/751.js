new Vue({
  el: '#app',
  data: {
    // your data here
  },
  methods: {
    submit() {
      // your submit logic here
    }
  }
})

Vue.component('v-form', {
  template: `
    <form 
      :method="method" 
      :enctype="enctype" 
      @submit.prevent="$emit('submit')" 
      @keyup.native.enter="$emit('submit')" 
      :id="id"
    >
      <slot></slot>
    </form>
  `,
  props: ['method', 'enctype', 'id']
})

// usage
<div id="app">
  <v-form 
    method="POST" 
    enctype="text/plain" 
    @submit="submit" 
    @keyup.native.enter="submit" 
    id="check-login-form"
  >
    <!-- your form fields here -->
  </v-form>
</div>