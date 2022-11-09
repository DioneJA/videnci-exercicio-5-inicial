<template>
  <q-page>
    <div class="q-pa-md items-start q-gutter-md flex flex-center">
      <div class="q-pa-md q-gutter-sm">
        <q-btn round color="blue-6" icon="list" to="/">
          <q-tooltip
            :offset="[10, 10]"
            transition-show="scale"
            transition-hide="scale"
            >Voltar para página de cadastro de alunos</q-tooltip
          >
        </q-btn>
       </div>
      <student-consult-card :id="id"></student-consult-card>
    </div>
  </q-page>
</template>

<script>
import StudentConsultCard from '../components/StudentConsultCard.vue'
export default {
  components: {
    StudentConsultCard
  },
  data () {
    return {
      id: this.$route.params.id
    }
  }
}
</script>

<style></style>
