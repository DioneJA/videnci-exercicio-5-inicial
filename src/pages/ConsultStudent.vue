<template>
  <q-page>
    <div class="q-pa-md items-start q-gutter-md flex flex-center">
      <btn-home></btn-home>
      <student-consult-card></student-consult-card>
    </div>
  </q-page>
</template>

<script>
import StudentConsultCard from '../components/cards/StudentConsultCard.vue'
import BtnHome from '../components/buttons/BtnHome.vue'
import { mapActions } from 'vuex'
export default {
  components: {
    StudentConsultCard, BtnHome
  },
  methods: {
    ...mapActions(['consultStudent'])
  },
  created () {
    this.consultStudent(this.$route.params.id)
  }
}
</script>

<style></style>
