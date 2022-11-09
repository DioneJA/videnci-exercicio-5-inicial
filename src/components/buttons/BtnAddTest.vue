<template>
<div>
  <div class="q-pa-md q-gutter-sm">
      <q-btn round color="green-6" icon="add" @click="prompt = true">
        <q-tooltip
          :offset="[10, 10]"
          transition-show="scale"
          transition-hide="scale"
          >Adicionar prova</q-tooltip>
      </q-btn>
    </div>

    <!-- Caixa de dialogo para cadastro de aluno-->
    <div class="q-pa-md q-gutter-sm">
      <q-dialog v-model="prompt" persistent>
        <q-card style="min-width: 350px">
          <q-card-section>
            <div class="text-h6">Digite o valor da prova:</div>
          </q-card-section>

          <q-card-section class="q-pt-none">
            <q-input
              dense
              v-model="test.value"
              autofocus
              @keyup.enter="saveTest(test)"
              required
              :rules="[ val => val >= 0 && val<=10 || 'Insira uma nota válida']"
              type="number"
              filled
            />
          </q-card-section>

          <q-card-actions align="right" class="text-primary">
            <q-btn flat label="Cancel" v-close-popup />
            <q-btn
              flat
              label="Adicionar prova"
              v-close-popup
              @click="saveTest(test)"
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
  props: {
    student: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      test: {}
    }
  },
  setup () {
    return {
      prompt: ref(false)
    }
  },
  methods: {
    saveTest (test) {
      if (test.value !== null && test.value >= 0 && test.value <= 10) {
        test.student = this.student
        console.log(test)
        this.$axios
          .post('/test/', test)
          .then((resp) => {
            this.test.value = null
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
