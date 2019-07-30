<template>
  <div>
    <b-form @submit="onSubmit" v-if="showForm">
    
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
          type="number"
          oninput="validity.valid||(value='');"          
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
          type="datetime"
          placeholder="Data de nascimento do Cliente"
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

            <b-form-group id="input-group-9" label="Saldo Total - Conta Eventual:" label-for="input-9">
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

        <div class="btn-group">
            <b-button @click="showWithdraw()" variant="outline-danger">Saque</b-button>
            <b-button @click="showDeposit()" variant="outline-success">Depósito</b-button>
            <b-button @click="showStatement()" variant="outline-info">Extrato</b-button>
            <b-button @click="editClient()" variant="outline-dark">Edição</b-button>
        </div>

    </b-form>

    <div>
        <b-alert variant="success" :show=showSuccess dismissible>Saque realizado com sucesso</b-alert>
        <b-alert variant="danger" :show=showError dismissible>Saque não pôde ser realizado</b-alert>
        <b-form @submit="onSubmit" v-if="showOperation">
        <b-form-group label="Conta:">
            <b-form-select v-model="accountSelected" required>
                <option :value="null" disabled>Selecione um tipo de conta</option>
                <option v-for="option in this.clientData.accountList" :value="option">{{ accountTypes[option.type] }}</option>
            </b-form-select>
        </b-form-group>
        <b-form-group
            v-if="accountSelected !== null"
            label="Saldo da conta:">
            <b-form-input readonly          
            v-model="accountSelected.value"
            ></b-form-input>
        </b-form-group>      
        <b-form-group
            v-if="accountSelected !== null"
            label="Valor do saque:">
            <b-form-input
            type="number"
            min="0"
            oninput="validity.valid||(value='');"
            v-model="withdrawValue"
            required
            placeholder="Apenas números"
            ></b-form-input>
        </b-form-group>      
        <div class="btn-group">
            <b-button @click="closeOperation" variant="outline-primary">Voltar</b-button>
            <b-button @click="makeWithdraw" variant="outline-danger">Sacar</b-button>
        </div>
        </b-form>
    </div>

       <div>
        <b-alert variant="success" :show=showSuccessDeposit dismissible>Depósito realizado com sucesso</b-alert>
        <b-alert variant="danger" :show=showErrorDeposit dismissible>Depósito não pôde ser realizado</b-alert>
        <b-form @submit="onSubmit" v-if="showOperationDeposit">
        <b-form-group label="Conta:">
            <b-form-select v-model="accountSelected" required>
                <option :value="null" disabled>Selecione um tipo de conta</option>
                <option v-for="option in this.clientData.accountList" :value="option">{{ accountTypes[option.type] }}</option>
            </b-form-select>
        </b-form-group>
        <b-form-group
            v-if="accountSelected !== null"
            label="Saldo da conta:">
            <b-form-input readonly          
            v-model="accountSelected.value"
            ></b-form-input>
        </b-form-group>      
        <b-form-group
            v-if="accountSelected !== null"
            label="Valor do depósito:">
            <b-form-input
            type="number"
            min="0"
            oninput="validity.valid||(value='');"
            v-model="depositValue"
            required
            placeholder="Apenas números"
            ></b-form-input>
        </b-form-group>      
        <div class="btn-group">
            <b-button @click="closeOperation" variant="outline-primary">Voltar</b-button>
            <b-button @click="makeDeposit" variant="outline-success">Depositar</b-button>
        </div>
        </b-form>
    </div>

    <div>
        <b-form @submit="onSubmit" v-if="showOperationStatement">
            <b-form-group label="Extrato por transação:">
                <b-form-group label="Conta:">
                    <b-form-select v-model="accountSelected" required>
                        <option :value="null" disabled>Selecione um tipo de conta</option>
                        <option v-for="option in this.clientData.accountList" :value="option">{{ accountTypes[option.type] }}</option>
                    </b-form-select>
                </b-form-group>
            </b-form-group>
            <b-table
                v-if="accountSelected !== null"
                striped
                hover
                :items="accountSelected.depositList.concat(accountSelected.withdrawList)"
                :fields="statementsTable.fields">
                <template slot="date" slot-scope="data">
                    {{ data.item.date | formatBrDate }}
                </template>
            </b-table>
            <div class="btn-group">
                <b-button @click="closeOperation" variant="outline-primary">Voltar</b-button>
            </div>
        </b-form>
    </div>

    <div>
        <b-alert variant="success" :show=showSuccessEdit dismissible>Edição realizada com sucesso</b-alert>
        <b-alert variant="danger" :show=showErrorEdit dismissible>Edição não pôde ser realizada</b-alert>        
        <b-form @submit="onSubmit" v-if="showEdit">

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
                <b-button @click="closeOperation" variant="outline-primary">Voltar</b-button>
                <b-button @click="saveClient" variant="outline-success">Salvar</b-button>
            </div>

        </b-form>        
    </div>        

  </div>
</template>

<script>
  import axios from 'axios';

  export default {
    props: {
        clientData: {}
    },
    mounted () {
        this.totalBalance = this.clientData.accountList[0].value + this.clientData.accountList[1].value
        this.calculateAge()
        this.formatBirthDate()
    },
    filters: {
        formatBrDate: function(value) {
            return new Date(value).toLocaleDateString(); 
        }
    },
    data() {
      return {
        showForm: true,
        showOperationStatement: false,
        showOperationDeposit: false,
        showOperation: false,
        showSuccess: false,
        showError: false,
        showSuccessDeposit: false,
        showErrorDeposit: false,
        showSuccessEdit: false,
        showErrorEdit: false,        
        showEdit: false,
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
        accountSelected: null,
        accountTypes: {'N': 'Normal', 'E': 'Eventual'},
        withdrawValue: 0,
        depositValue: 0,
        statementsTable: {
            fields: {
                date: {
                    label: 'Data',
                    sortable: true
                },
                value: {
                    label: 'Valor'
                }, 
                type: {
                    label: 'Tipo',
                    sortable: true
                }                
            }
        }
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
      },
      formatBirthDate() {
          this.clientData.birthDate = new Date(this.clientData.birthDate).toLocaleDateString()
      },
      showWithdraw() {
          this.showForm = false
          this.showOperation = true
      },
      showDeposit() {
          this.showForm = false
          this.showOperationDeposit = true
      },
      showStatement() {
          this.showForm = false
          this.showOperationStatement = true
      },
      makeWithdraw() {
        axios
            .post(`http://localhost:8080/operacao/saque/${this.accountSelected.idAccount}`, { value: this.withdrawValue })
            .then((response) => {
                this.accountSelected.value = response.data.value
                this.showSuccess = true
            })
            .catch((error) => {
                this.showError = true
            })
      },
       makeDeposit() {
        axios
            .post(`http://localhost:8080/operacao/deposito/${this.accountSelected.idAccount}`, { value: this.depositValue })
            .then((response) => {
                this.accountSelected.value = response.data.value
                this.showSuccessDeposit = true
            })
            .catch((error) => {
                this.showErrorDeposit = true
            })
      },
      saveClient() {
          var clientEdit = Object.assign({}, this.clientData)
          delete clientEdit.birthDate
          axios
            .put(`http://localhost:8080/cliente/${clientEdit.idClient}`, clientEdit)
            .then((response) => {
                this.clientData = response.data
                this.formatBirthDate()
                this.showSuccessEdit = true
            })
            .catch((error) => {
                this.showErrorEdit = true
            })
      },
      editClient() {
        this.showForm = false
        this.showEdit = true
      },
      closeOperation() {
          this.showForm = true
          this.showOperation= false
          this.showSuccessDeposit= false
          this.showErrorDeposit= false
          this.showOperationDeposit= false
          this.showOperationStatement = false
          this.showSuccess = false
          this.showError = false
          this.showEdit = false
          this.showSuccessEdit = false
          this.showErrorEdit = false
      }
    }
  }
</script>
<style>
.btn-group button {
    margin: 0 5px;
}
</style>