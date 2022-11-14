<template>
  <q-dialog v-model="confirm" persistent>
      <q-card>
        <q-card-section class="row items-center">
          <q-avatar icon="warning" color="orange" text-color="white" />
          <span class="q-ml-sm"
            ><strong>{{message}}</strong></span
          >
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="Cancelar" color="primary" @click="closeConfirmDialog()"/>
          <q-btn
            flat
            label="Confirmar"
            color="primary"
            @click="deleteTest(id) , closeConfirmDialog()"
          />
        </q-card-actions>
      </q-card>
    </q-dialog>
</template>

<script>
import { mapActions, mapState } from 'vuex'
export default {
  computed: {
    ...mapState(['confirm', 'message', 'id'])
  },
  methods: {
    ...mapActions(['openConfirmDialog', 'closeConfirmDialog', 'deleteTest'])
  }
}
</script>

<style lang="scss" scoped>

</style>
