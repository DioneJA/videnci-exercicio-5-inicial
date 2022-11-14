<template>
  <div class="flex flex-center q-ml-sm">
    <q-btn
      color="red-6"
      icon="delete"
      label="Excluir"
      @click="openConfirmDialog(confirm)"
      tyle="width: 100%"
      ><q-tooltip
        :offset="[10, 10]"
        transition-show="scale"
        transition-hide="scale"
        >Excluir este aluno</q-tooltip
      ></q-btn
    >

    <confirm-dialog :id="id"/>
    <error-dialog/>
  </div>
</template>

<script>
import ConfirmDialog from '../dialogs/ConfirmStudentDialog.vue'
import ErrorDialog from '../dialogs/ErrorDialog.vue'
import { mapActions } from 'vuex'

export default {
  props: {
    id: {
      required: true
    }
  },
  components: {
    ConfirmDialog, ErrorDialog
  },
  data () {
    return {
      confirm: {
        boolean: true,
        msg: 'Você tem certeza que deseja excluir o aluno?',
        id: this.id
      }
    }
  },
  methods: {
    ...mapActions(['openConfirmDialog'])
  }
}
</script>

<style lang="scss" scoped></style>
