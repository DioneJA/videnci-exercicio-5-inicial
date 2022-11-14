<template>
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
              @keyup.enter="postTest(test), closeAddDialog()"
              required
              :rules="[ val => val >= 0 && val<=10 || 'Insira uma nota válida']"
              type="number"
              filled
            />
          </q-card-section>

          <q-card-actions align="right" class="text-primary">
            <q-btn flat label="Cancel"  @click="closeAddDialog()"/>
            <q-btn
              flat
              label="Adicionar prova"
              v-close-popup
              @click="postTest(test),closeAddDialog()"
            />
          </q-card-actions>
        </q-card>
      </q-dialog>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  data () {
    return {
      test: {
        student: {
          id: this.$route.params.id
        }
      }
    }
  },
  methods: {
    ...mapActions(['postTest', 'closeAddDialog'])
  },
  computed: {
    ...mapState(['prompt'])
  }
}
</script>

<style lang="scss" scoped>

</style>
