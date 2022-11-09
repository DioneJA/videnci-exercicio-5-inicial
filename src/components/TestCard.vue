<template>
     <div class="q-pa-md row items-start q-gutter-md flex flex-center">
          <q-card
            class="my-card bg-blue-white-10 text-black"
            v-for="(x, index) in tests"
            :key="x.id"
            style="width:44%"
          >
            <q-card-section class="row flex flex-center" v-if="tests.length>0" >
              <div>
                <div class="text-h6">
                  <strong>Prova: </strong>{{ index + 1 }}
                </div>
                <div class="text-subtitle1">
                  <strong>ID: </strong>{{ x.id }}
                </div>
                <div class="text-subtitle1">
                  <strong>Nota: </strong>{{ x.value }}
                </div>
              </div>
              <div class="q-pa-md q-ml-sm">
                <q-btn
                  round
                  color="red"
                  icon="delete"
                  @click="(confirm = true), (testId = x.id)"
                />
              </div>
            </q-card-section>
          </q-card>
          <!-- Componente de dialogo confirmar precisa de props id -->
          <q-dialog v-model="confirm" persistent>
            <q-card>
              <q-card-section class="row items-center">
                <q-avatar icon="warning" color="orange" text-color="white" />
                <span class="q-ml-sm"
                  ><strong>Você tem certeza que deseja excluir a prova?</strong></span
                >
              </q-card-section>

              <q-card-actions align="right">
                <q-btn flat label="Cancelar" color="primary" v-close-popup />
                <q-btn
                  flat
                  label="Confirmar"
                  color="primary"
                  v-close-popup
                  @click="deleteTest(testId)"
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
      type: String,
      required: true
    }
  },
  data () {
    return {
      tests: [],
      testId: 0
    }
  },
  setup () {
    return {
      confirm: ref(false)
    }
  },
  created () {
    this.consultTestsOfStudent()
  },
  methods: {
    consultTestsOfStudent () {
      this.$axios
        .get('/test/student/' + this.id)
        .then((resp) => {
          this.tests = resp.data
        })
        .catch((err) => {
          console.log(err)
        })
    },
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
