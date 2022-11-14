<template>
<div>
  <div class="q-pa-md q-gutter-sm">
      <q-btn round color="green-6" icon="add" @click="openAddDialog()">
        <q-tooltip
          :offset="[10, 10]"
          transition-show="scale"
          transition-hide="scale"
          >Adicionar prova</q-tooltip>
      </q-btn>
    </div>
  <add-test-dialog></add-test-dialog>
  </div>
</template>

<script>
import AddTestDialog from '../dialogs/AddTestDialog.vue'
import { mapActions } from 'vuex'
export default {
  components: {
    AddTestDialog
  },
  methods: {
    ...mapActions(['openAddDialog'])
  }
}
</script>

<style lang="scss" scoped></style>
