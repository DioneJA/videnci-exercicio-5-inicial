<template>
   <div class="q-pa-md row items-start q-gutter-md flex flex-center">
      <q-card
        class="my-card bg-blue-grey-10 text-white"
        v-for="(p, index) in students"
        :key="p.id"
      >
        <q-card-section>
          <div class="text-h6">{{ index + 1 }}</div>
          <div class="text-subtitle1"><strong>ID: </strong>{{ p.id }}</div>
          <div class="text-subtitle1"><strong>Nome: </strong>{{ p.name }}</div>
        </q-card-section>

        <q-card-actions>
          <btn-consult-student :id="p.id"></btn-consult-student>
          <btn-delete-student :id="p.id"></btn-delete-student>
        </q-card-actions>
      </q-card>
    </div>
</template>

<script>
import BtnConsultStudent from '../buttons/BtnConsultStudent.vue'
import BtnDeleteStudent from '../buttons/BtnDeleteStudent.vue'
export default {
  components: {
    BtnConsultStudent, BtnDeleteStudent
  },
  props: {
    students: {
      type: Array,
      required: true
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
