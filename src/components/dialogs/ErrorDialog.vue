<template>
    <!-- Componente de dialogo erro ao excluir -->
    <q-dialog v-model="dialog" :position="'top'">
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
          <q-btn flat label="OK" color="blue" @click="closeErrorDialog()" />
        </q-card-actions>
      </q-card>
    </q-dialog>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  computed: {
    ...mapState(['dialog'])
  },
  methods: {
    ...mapActions(['closeErrorDialog'])
  }
}
</script>

<style lang="scss" scoped>

</style>
