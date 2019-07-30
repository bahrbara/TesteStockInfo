<template>
  <div>
    <b-table striped hover :items="items" :fields="fields">
        <template slot="name" slot-scope="data">
            <a href="#" @click="showModal(data.item)">{{ data.item.name }}</a>
        </template>
    </b-table>

    <b-button class="mt-3" variant="outline-primary" block @click="showModalCreateClient">Cadastrar Cliente</b-button>

    <b-modal ref="modalEditClient" hide-footer :title=currentClient.name>
        <div class="d-block text-center">
            <FormClient v-bind:clientData="currentClient"></FormClient>
        </div>
    </b-modal>

    <b-modal ref="modalCreateClient" hide-footer title="Novo cliente">
        <div class="d-block text-center">
            <FormCreateClient></FormCreateClient>
        </div>
    </b-modal>    
  </div>
</template>

<script>
  import axios from 'axios';
  import FormEditClient from './FormEditClient.vue'
  import FormCreateClient from './FormCreateClient.vue'

  export default {
    name: 'ListClients',
    components: {
        FormEditClient,
        FormCreateClient
    },
    mounted () {
        this.getClientList()
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
        getClientList() {
            axios
                .get('http://localhost:8080/cliente')
                .then(response => (this.items = response.data))
        },
        showModal(data) {
            this.currentClient = data
            this.$refs['modalEditClient'].show()
        },
        showModalCreateClient(data) {
            this.$refs['modalCreateClient'].show()
        },        
        hideModal() {
            this.$refs['modalEditClient'].hide()
            this.getClientList()
        },
        hideModalCreateClient() {
            this.$refs['modalEditClient'].hide()
            this.getClientList()
        }        
    }
  }
</script>