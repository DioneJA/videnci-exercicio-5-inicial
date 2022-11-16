<template>
    <!-- Caixa de dialogo para cadastro de aluno-->
    <div class="q-pa-md q-gutter-sm">
      <q-dialog v-model="prompt" persistent>
        <q-card style="min-width: 350px">
          <q-card-section>
            <div class="text-h6">Digite o nome do aluno que deseja adicionar: </div>
          </q-card-section>

          <q-card-section class="q-pt-none">
            <q-input
              dense
              v-model="student.name"
              autofocus
              @keyup.enter="postStudent(student),closeAddDialog(), student.name=''"
              required
              :rules="[ val => val.length >= 3 || null || 'Insira pelo menos 3 caracteres' ]"
            />
          </q-card-section>

          <q-card-actions align="right" class="text-primary">
            <q-btn flat label="Cancel" @click="closeAddDialog(), student.name=''"/>
            <q-btn
              flat
              label="Adicionar aluno"
              @click="postStudent(student), closeAddDialog(), student.name=''"
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
      student: {}
    }
  },
  computed: {
    ...mapState(['prompt'])
  },
  methods: {
    ...mapActions(['closeAddDialog', 'postStudent'])
  }
}
</script>

<style lang="scss" scoped>

</style>
