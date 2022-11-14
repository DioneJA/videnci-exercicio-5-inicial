<template>
  <div>
    <div class="q-pa-md q-ml-sm">
      <q-btn
      round
      color="red"
      icon="delete"
      @click="openConfirmDialog(confirm)">
        <q-tooltip
          :offset="[10, 10]"
          transition-show="scale"
          transition-hide="scale"
          >Excluir esta prova
        </q-tooltip>
        </q-btn>
      </div>
      <confirm-dialog></confirm-dialog>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import ConfirmDialog from '../dialogs/ConfirmTestDialog.vue'
export default {
  components: {
    ConfirmDialog
  },
  props: {
    id: {
      required: true
    }
  },
  data () {
    return {
      confirm: {
        boolean: true,
        msg: 'Você tem certeza que deseja excluir a prova?',
        id: this.id
      }
    }
  },
  methods: {
    ...mapActions(['openConfirmDialog'])
  }
}
</script>

<style lang="scss" scoped>

</style>
