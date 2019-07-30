<template>
  <div>
    <b-alert variant="success" :show=showSuccess dismissible>Cadatro realizado com sucesso</b-alert>
    <b-alert variant="danger" :show=showError dismissible>Cadastro não pôde ser realizado</b-alert>         
    <b-form>
    
       <b-form-group label="Nome:">
        <b-form-input
          v-model="clientData.name"
          placeholder="Nome completo"
        ></b-form-input>
      </b-form-group>

        <b-form-group id="input-group-2" label="CPF:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="clientData.cpf"
          required
          placeholder="Apenas números"
          type="number"
          max="99999999999"
          oninput="validity.valid||(value='');"          
        ></b-form-input>
      </b-form-group>
        
      <b-form-group id="input-group-3" label="Gênero:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="clientData.gender"
          :options="genders"
          required
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-4" label="Data de Nascimento:" label-for="input-4">
        <b-form-input
          id="input-4"
          v-model="clientData.birthDate"
          required
          type="datetime"
          placeholder="Data de nascimento do Cliente"
        ></b-form-input>
      </b-form-group>

        <b-form-group
            id="input-group-5"
            label="E-mail:"
            label-for="input-5"
        >
            <b-form-input
            id="input-5"
            v-model="clientData.email"
            type="email"
            required
            placeholder="Insira e-mail"
            ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-6" label="Telefone:" label-for="input-6">
            <b-form-input
            id="input-6"
            v-model="clientData.phoneNumber"
            required
            placeholder="Insira número de telefone com DDD"
            ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-7" label="Endereço:" label-for="input-7">
            <b-form-input
            id="input-7"
            v-model="clientData.address"
            required
            placeholder="Insira endereço completo"
            ></b-form-input>
        </b-form-group>

        <div class="btn-group">
            <b-button @click="create" variant="outline-success">Cadastrar</b-button>
        </div>

    </b-form>

  </div>
</template>

<script>
  import axios from 'axios';

  export default {
    mounted () {
    },
    data() {
      return {
        showSuccess: false,
        showError: false,
        genders: [{ text: 'Feminino', value: 'F' }, { text: 'Masculino', value: 'M' }],
        clientData: {}
      }
    },
    methods: {
      create() {
        
        this.clientData.phone_number = this.clientData.phoneNumber
        this.clientData.birth_date = this.clientData.birthDate

        axios
            .post(`http://localhost:8080/cliente/`, this.clientData)
            .then((response) => {
                this.clientData = {}
                this.showSuccess = true
            })
            .catch((error) => {
                this.showError = true
            })
      },
      closeOperation() {
            this.showForm = true
      }
    }
  }
</script>
<style>
.btn-group button {
    margin: 0 5px;
}
</style>