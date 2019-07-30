<template>
  <div id="app">
    <h1>Lista de Clientes</h1>
    <ListClients></ListClients>
  </div>
</template>

<script>
import ListClients from './components/ListClients.vue'

export default {
  name: 'app',
  components: {    
    ListClients
  }
}

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
