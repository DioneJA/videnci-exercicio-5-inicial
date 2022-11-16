<template>
  <q-page padding>
    <student-card v-if="students.length>0"></student-card>
    <empty-card v-else>Nenhum aluno cadastrado!</empty-card>
    <btn-add-student/>
  </q-page>
</template>

<script>
import BtnAddStudent from '../components/buttons/BtnAddStudent.vue'
import StudentCard from '../components/cards/StudentCard.vue'
import EmptyCard from '../components/cards/EmptyCard.vue'
import { mapActions, mapState } from 'vuex'

export default {
  components: {
    BtnAddStudent, StudentCard, EmptyCard
  },
  created () {
    this.fetchStudents()
  },
  methods: {
    ...mapActions(['fetchStudents'])
  },
  computed: {
    ...mapState(['students'])
  }
}
</script>
