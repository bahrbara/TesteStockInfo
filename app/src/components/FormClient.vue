<template>
  <div>
    <b-form @submit="onSubmit" v-if="show">
    
       <b-form-group id="input-group-1" label="Nome:" label-for="input-1">
        <b-form-input readonly
          id="input-1"
          v-model="clientData.name"
          required
          placeholder="Nome completo"
        ></b-form-input>
      </b-form-group>

        <b-form-group id="input-group-2" label="CPF:" label-for="input-2">
        <b-form-input readonly
          id="input-2"
          v-model="clientData.cpf"
          required
          placeholder="Apenas números"
        ></b-form-input>
      </b-form-group>
        
      <b-form-group id="input-group-3" label="Gênero:" label-for="input-3">
        <b-form-select disabled
          id="input-3"
          v-model="clientData.gender"
          :options="genders"
          required
        ></b-form-select>
      </b-form-group>

         <b-form-group id="input-group-11" label="Idade:" label-for="input-11">
        <b-form-input readonly
          id="input-11"
          v-model="clientAge"
          required
          placeholder="Apenas números"
        ></b-form-input>
      </b-form-group>

        <b-form-group id="input-group-4" label="Data de Nascimento:" label-for="input-4">
        <b-form-input readonly
          id="input-4"
          v-model="clientData.birthDate"
          required
          placeholder="Idade do Cliente"
        ></b-form-input>
      </b-form-group>

    <b-form-group
        id="input-group-5"
        label="E-mail:"
        label-for="input-5"
      >
        <b-form-input readonly
          id="input-5"
          v-model="clientData.email"
          type="email"
          required
          placeholder="Insira e-mail"
        ></b-form-input>
      </b-form-group>

        <b-form-group id="input-group-6" label="Telefone:" label-for="input-6">
        <b-form-input readonly
          id="input-6"
          v-model="clientData.phoneNumber"
          required
          placeholder="Insira número de telefone com DDD"
        ></b-form-input>
      </b-form-group>

          <b-form-group id="input-group-7" label="Endereço:" label-for="input-7">
        <b-form-input readonly
          id="input-7"
          v-model="clientData.address"
          required
          placeholder="Insira endereço completo"
        ></b-form-input>
      </b-form-group>

          <b-form-group id="input-group-8" label="Saldo Total - Conta Normal:" label-for="input-8">
        <b-form-input readonly
          id="input-8"
          v-model="clientData.accountList[0].value"
          required
          placeholder="Saldo Conta Normal"
        ></b-form-input>
      </b-form-group>

          <b-form-group id="input-group-9" label="Saldo Total - Conta Evetual:" label-for="input-9">
        <b-form-input readonly
          id="input-9"
          v-model="clientData.accountList[1].value"
          required
          placeholder="Saldo Conta Eventual"
        ></b-form-input>
      </b-form-group>

          <b-form-group id="input-group-10" label="Saldo Total:" label-for="input-10">
        <b-form-input readonly
          id="input-10"
          v-model="totalBalance"
          required
          placeholder="Insira endereço completo"
        ></b-form-input>
      </b-form-group>

        <div id="btn-group">
            <b-button type="submit" variant="outline-danger">Saque</b-button>
            <b-button type="submit" variant="outline-success">Depósito</b-button>
            <b-button type="submit" variant="outline-info">Extrato</b-button>
            <b-button type="submit" variant="outline-dark">Edição</b-button>
        </div>

    </b-form>
  </div>
</template>

<script>
  export default {
    props: {
        clientData: {}
    },
    mounted () {
    this.totalBalance = this.clientData.accountList[0].value + this.clientData.accountList[1].value
    this.calculateAge();
    },
    data() {
      return {
        totalBalance: 0,
        clientAge: 0,
        form: {
          name: '',
          cpf: '',
          gender: '',
          age: '',
          birthDate: '',
          email: '',
          phoneNumber: '',
          address: ''
        },
        genders: [{ text: 'Feminino', value: 'F' }, { text: 'Masculino', value: 'M' }],
        show: true
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      },
      calculateAge() {
        var birthDateClient = new Date(this.clientData.birthDate)
        var ageDifMs = Date.now() - birthDateClient.getTime();
        var ageDate = new Date(ageDifMs); // miliseconds from epoch
        this.clientAge = Math.abs(ageDate.getUTCFullYear() - 1970);
      }
    }
  }
</script>
<style>
#btn-group button {
    margin: 0 5px;
}
</style>