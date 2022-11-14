<template>
  <q-btn
    color="indigo-6"
    :to="'/consult/' + id"
    icon="edit"
    label="Consutar">
    <q-tooltip
    :offset="[10, 10]"
    transition-show="scale"
    transition-hide="scale"
    >
    Ver informações detalhadas deste aluno
    </q-tooltip>
</q-btn>
</template>

<script>
export default {
  props: {
    id: {
      required: true
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
