

<template>
  <div>
    <b-table striped hover :items="items" :fields="fields">
        <template slot="name" slot-scope="data">
            <a @click="showModal(data.item)">{{ data.item.name }}</a>
        </template>
    </b-table>
        <b-button class="mt-3" variant="outline-primary" block @click="hideModal">Cadastrar Cliente</b-button>    
    <b-modal ref="my-modal" hide-footer :title=currentClient.name>
        <div class="d-block text-center">
            <FormClient v-bind:clientData="currentClient"></FormClient>
        </div>
    </b-modal>
  </div>
</template>

<script>
  import axios from 'axios';
  import FormClient from './FormClient.vue'

  export default {
    name: 'ListClients',
    components: {
        FormClient
    },
    mounted () {
        axios
            .get('http://localhost:8080/cliente')
            .then(response => (this.items = response.data))
    },    
    data() {
      return {
        currentClient: {},
        fields: {
          name: {
            label: 'Nome',
            sortable: true
          },
          cpf: {
            label: 'CPF',
            sortable: true
          },
          phoneNumber: {
            label: 'Telefone',
            sortable: true
          }
        },          
        items: []
      }
    },
    methods: {
        showModal(data) {
            this.currentClient = data
            this.$refs['my-modal'].show()
        },
        hideModal() {
            this.$refs['my-modal'].hide()
        }     
    }
  }
</script>