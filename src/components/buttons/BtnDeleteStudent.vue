<template>
  <div class="flex flex-center q-ml-sm">
    <q-btn
      color="red-6"
      icon="delete"
      label="Excluir"
      @click="confirm = true"
      tyle="width: 100%"
      ><q-tooltip
        :offset="[10, 10]"
        transition-show="scale"
        transition-hide="scale"
        >Excluir este aluno</q-tooltip
      ></q-btn
    >
    <!-- Componente de dialogo confirmar precisa de props id -->
    <q-dialog v-model="confirm" persistent>
      <q-card>
        <q-card-section class="row items-center">
          <q-avatar icon="warning" color="orange" text-color="white" />
          <span class="q-ml-sm"
            ><strong>Você tem certeza que deseja excluir o aluno?</strong></span
          >
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="Cancelar" color="primary" v-close-popup />
          <q-btn
            flat
            label="Confirmar"
            color="primary"
            v-close-popup
            @click="deleteStudent(id)"
          />
        </q-card-actions>
      </q-card>
    </q-dialog>

    <!-- Componente de dialogo erro ao excluir -->
    <q-dialog v-model="dialog" :position="position">
      <q-card style="width: 350px">
        <q-card-section class="flex flex-center">
          <q-avatar
            icon="error"
            style="font-size: 30px"
            color="red"
            text-color="white"
            class="q-mr-sm"
          />
          <span class="text-h6">Erro ao excluir aluno</span>
        </q-card-section>

        <q-card-section class="q-pt-none">
          O aluno possuí provas cadastradas em seu perfil, por favor, excluí-las
          antes!
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="OK" color="blue" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </div>
</template>

<script>
import { ref } from 'vue'
export default {
  props: {
    id: {
      type: Number,
      required: true
    }
  },
  setup () {
    return {
      confirm: ref(false),
      dialog: ref(false),
      position: ref('top')
    }
  },
  methods: {
    deleteStudent (id) {
      this.$axios
        .delete('/student/' + id)
        .then(() => {
          this.reload()
        })
        .catch((error) => {
          console.log(error)
          this.dialog = true
        })
    },
    reload () {
      window.location.reload(true)
    }
  }
}
</script>

<style lang="scss" scoped></style>
