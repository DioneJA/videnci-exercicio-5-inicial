<template>
<div>
  <div class="q-pa-md q-gutter-sm">
      <q-btn round color="green-6" icon="add" @click="openAddDialog()">
        <q-tooltip
          :offset="[10, 10]"
          transition-show="scale"
          transition-hide="scale"
          >Adicionar aluno</q-tooltip>
      </q-btn>
    </div>
    <add-dialog/>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import AddDialog from '../dialogs/AddStudentDialog.vue'
export default {
  components: {
    AddDialog
  },
  methods: {
    ...mapActions(['openAddDialog'])
  }
}
</script>

<style lang="scss" scoped></style>
