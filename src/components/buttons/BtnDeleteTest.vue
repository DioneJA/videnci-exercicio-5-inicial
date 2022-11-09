<template>
  <div>
    <div class="q-pa-md q-ml-sm">
      <q-btn
      round
      color="red"
      icon="delete"
      @click="(confirm = true)">
        <q-tooltip
          :offset="[10, 10]"
          transition-show="scale"
          transition-hide="scale"
          >Excluir esta prova
        </q-tooltip>
        </q-btn>
      </div>
         <!-- Componente de dialogo confirmar -->
        <q-dialog v-model="confirm" persistent>
            <q-card>
              <q-card-section class="row items-center">
                <q-avatar icon="warning" color="orange" text-color="white" />
                <span class="q-ml-sm"
                  ><strong>Você tem certeza que deseja excluir a prova?</strong></span>
              </q-card-section>

              <q-card-actions align="right">
                <q-btn flat label="Cancelar" color="primary" v-close-popup />
                <q-btn
                  flat
                  label="Confirmar"
                  color="primary"
                  v-close-popup
                  @click="deleteTest(id)"
                />
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
      required: true
    }
  },
  setup () {
    return {
      confirm: ref(false)
    }
  },
  methods: {
    deleteTest (id) {
      this.$axios
        .delete('/test/' + id)
        .then(() => {
          this.reload()
        })
        .catch((error) => {
          console.log(error)
        })
    },
    reload () {
      window.location.reload(true)
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
