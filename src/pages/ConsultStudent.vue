<template>
  <q-page>
    <div class="q-pa-md items-start q-gutter-md flex flex-center">
      <btn-home></btn-home>
      <student-consult-card :id="id"></student-consult-card>
    </div>
  </q-page>
</template>

<script>
import StudentConsultCard from '../components/cards/StudentConsultCard.vue'
import BtnHome from '../components/buttons/BtnHome.vue'
export default {
  components: {
    StudentConsultCard, BtnHome
  },
  data () {
    return {
      id: this.$route.params.id
    }
  }
}
</script>

<style></style>
