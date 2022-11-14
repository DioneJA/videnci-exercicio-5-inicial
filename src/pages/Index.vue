<template>
  <q-page padding>
    <student-card :students="students" v-if="students.length>0"></student-card>
    <empty-card v-else>Nenhum aluno cadastrado!</empty-card>
    <btn-add-student/>
  </q-page>
</template>

<script>
import BtnAddStudent from '../components/buttons/BtnAddStudent.vue'
import StudentCard from '../components/cards/StudentCard.vue'
import EmptyCard from '../components/cards/EmptyCard.vue'
import { mapActions } from 'vuex'

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
    students () {
      return this.$store.state.students
    }
  }
}
</script>
