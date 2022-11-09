<template>
<div>
  <div class="q-pa-md q-gutter-sm">
      <q-btn round color="green-6" icon="add" @click="prompt = true">
        <q-tooltip
          :offset="[10, 10]"
          transition-show="scale"
          transition-hide="scale"
          >Adicionar aluno</q-tooltip>
      </q-btn>
    </div>

    <!-- Caixa de dialogo para cadastro de aluno-->
    <div class="q-pa-md q-gutter-sm">
      <q-dialog v-model="prompt" persistent>
        <q-card style="min-width: 350px">
          <q-card-section>
            <div class="text-h6">Digite o nome do aluno:</div>
          </q-card-section>

          <q-card-section class="q-pt-none">
            <q-input
              dense
              v-model="student.name"
              autofocus
              @keyup.enter="saveStudent(student)"
              required
              :rules="[ val => val.length >= 3|| 'Insira pelo menos 3 caracteres' ]"
            />
          </q-card-section>

          <q-card-actions align="right" class="text-primary">
            <q-btn flat label="Cancel" v-close-popup />
            <q-btn
              flat
              label="Adicionar aluno"
              v-close-popup
              @click="saveStudent(student)"
            />
          </q-card-actions>
        </q-card>
      </q-dialog>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'
export default {
  data () {
    return {
      student: {}
    }
  },
  setup () {
    return {
      prompt: ref(false)
    }
  },
  methods: {
    saveStudent (student) {
      if (student.name !== '') {
        this.$axios
          .post('/student/', student)
          .then((resp) => {
            this.student.name = ''
            console.log(resp)
            this.reload()
          })
          .catch((error) => {
            console.log(error)
          })
      }
    },
    reload () {
      window.location.reload(true)
    }
  }
}
</script>

<style lang="scss" scoped></style>
