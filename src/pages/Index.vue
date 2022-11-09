<template>
  <q-page padding>
    <student-card :students="students"></student-card>
    <btn-add-student/>
  </q-page>
</template>

<script>

import BtnAddStudent from '../components/BtnAddStudent.vue'
import StudentCard from '../components/StudentCard.vue'
export default {
  components: {
    BtnAddStudent, StudentCard
  },
  data () {
    return {
      students: []
    }
  },
  created () {
    this.getStudents()
  },
  methods: {
    getStudents () {
      this.$axios
        .get('/student')
        .then((res) => {
          this.students = res.data
        })
        .catch((error) => {
          console.log(error)
        })
    }
  }
}
</script>
